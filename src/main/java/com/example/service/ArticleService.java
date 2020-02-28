package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Article;
import com.example.repository.ArticleRepository;

/**
 * 記事関連サービスクラス.
 * 
 * @author igamasayuki
 *
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * 記事一覧を取得します.
	 * 記事に含まれているコメント一覧も同時に取得します
	 * 
	 * @return コメントを含んだ記事一覧情報
	 */
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	/**
	 * 記事を登録します.
	 * 
	 * @param article
	 *            記事情報
	 * @return 登録した記事情報
	 */
	public Article save(Article article) {
		return articleRepository.insert(article);
	}

	/**
	 * 記事を削除します.
	 * 
	 * @param id　削除したい記事ID
	 */
	public void delete(int id) {
		articleRepository.delete(id);
	}
	
	/**
	 * 記事投稿者名で前方一致検索します.
	 * 
	 * @param name　記事投稿者名
	 * @return 記事とコメントのリスト
	 */
	public List<Article> findByUserName(String name) {
		return articleRepository.findByUserName(name);
	}
}
