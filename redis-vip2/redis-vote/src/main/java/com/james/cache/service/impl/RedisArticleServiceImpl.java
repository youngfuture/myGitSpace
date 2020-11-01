package com.james.cache.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.james.cache.basic.Constants;
import com.james.cache.service.RedisArticleService;
import com.james.cache.utils.JedisUtils;

/**
 * 文章发布使用redis技术
 */
@Service
public class RedisArticleServiceImpl implements RedisArticleService{

	@Resource
	private JedisUtils jedis;
	/**
	 * 文章提交发布
	 *  标题  内容  链接  用户ID
	 * @return 文章的ID
	 */
	@Override
	public String postArticle(String title, String content, String link, String userId) {

		//article:001
		String articleId = String.valueOf(jedis.incr("article:")); // articleId=1


		//投票键： voted:
		String voted = "voted:" + articleId;

		jedis.sadd(voted, userId);
		jedis.expire(voted, Constants.ONE_WEEK_IN_SECONDS);

		long now = System.currentTimeMillis() / 1000;

		String article = "article:" + articleId;

		HashMap<String,String> articleData = new HashMap<String,String>();
		articleData.put("title", title);
		articleData.put("link", link);
		articleData.put("user", userId);
		articleData.put("now", String.valueOf(now));
		articleData.put("votes", "1");

		jedis.hmset(article, articleData);
		jedis.zadd("score:info", now + Constants.VOTE_SCORE, article);
		jedis.zadd("time:", now, article);

		return articleId;
	}




	/**
	 * 文章投票
	 * @param  （article:001）  //001
	 */
	@Override
	public void articleVote(String userId, String article) {


		//计算投票截止时间
		long cutoff = (System.currentTimeMillis() / 1000) - Constants.ONE_WEEK_IN_SECONDS;
		//检查是否还可以对文章进行投票,如果该文章的发布时间比截止时间小，则已过期，不能进行投票
		if (jedis.zscore("time:", article) < cutoff){
			return;
		}
		//获取文章主键id
		String articleId = article.substring(article.indexOf(':') + 1); ////article:1    1

		if (jedis.sadd("voted:" + articleId, userId) == 1) {
			jedis.zincrby("score:info", Constants.VOTE_SCORE, article);//分值加400
			jedis.hincrBy(article, "votes", 1l);//投票数加1
		}
	}





	/**
	 * 文章列表查询（分页）
	 * @param  page  key
	 * @return redis查询结果
	 */
	@Override
	public List<Map<String, String>> getArticles(int page, String key) {
		int start = (page - 1) * Constants.ARTICLES_PER_PAGE;
		int end = start + Constants.ARTICLES_PER_PAGE - 1;
		//倒序查询出投票数最高的文章，zset有序集合，分值递减
		Set<String> ids = jedis.zrevrange(key, start, end);
		List<Map<String,String>> articles = new ArrayList<Map<String,String>>();
		for (String id : ids){
			Map<String,String> articleData = jedis.hgetAll(id);
			articleData.put("id", id);
			articles.add(articleData);
		}

		return articles;
	}


	@Override
	public String hget(String key, String feild) {
		return jedis.hget(key,feild);
	}

	@Override
	public Map<String, String> hgetAll(String key) {
		return jedis.hgetAll(key);
	}

}
