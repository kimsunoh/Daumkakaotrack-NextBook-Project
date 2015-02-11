package com.scratchback.spring.controller;

import java.util.Locale;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scratchback.spring.service.Sample;
import com.scratchback.spring.test.Blog;
import com.scratchback.spring.test.BlogDataSourceFactory;
import com.scratchback.spring.test.BlogMapper;
import com.scratchback.spring.test.Dummy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private Sample sample;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		// autowired var
		String test = sample.getSampleString("fighting");

		// sample dummy setter
		Dummy dummy = new Dummy();
		dummy.setA("zzzzzzzzzzzzzzzzz");

		Blog blog = initDB();

		model.addAttribute("blog", blog);
		model.addAttribute("test", test);
		model.addAttribute("dummy", dummy);

		return "index";
	}

	private Blog initDB() {
		Blog blog;

		DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development",
				transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(configuration);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			blog = mapper.selectBlog(3);
		} finally {
			session.close();
		}
		return blog;
	}
}
