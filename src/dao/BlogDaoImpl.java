package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface {

	@Override
	public void insertBlog(Blog blog) throws Exception {
		// TODO Auto-generated method stub
		ConnectionManager cm = new ConnectionManager();
		String sql="insert into project_week5_2(b_id,b_title,b_description,b_date)values(?,?,?,?)";
		PreparedStatement ps = cm.getConnection().prepareStatement(sql);
		ps.setLong(1, blog.getBlogId());
		ps.setString(2, blog.getBlogTitle());
		ps.setString(3, blog.getBlogDescription());
		ps.setDate(4, java.sql.Date.valueOf(blog.getPostedOn()));
		ps.executeUpdate();
		cm.getConnection().close();
	}

	@Override
	public List selectAllBlogs() throws Exception {
		// TODO Auto-generated method stub
		List<Blog> list=new ArrayList<Blog>(); 
		
		ConnectionManager cm = new ConnectionManager();
		String sql="select * from project_week5_2";
		PreparedStatement ps = cm.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		Blog blog = new Blog();
		while(rs.next()) {
			
			long blogId = rs.getLong(1);
			String blogTitle = rs.getString(2);
			String BlogDescription = rs.getString(3);
			LocalDate postedOn = rs.getDate(4).toLocalDate();
			
			blog.setBlogId(blogId);
			blog.setBlogTitle(blogTitle);
			blog.setBlogDescription(BlogDescription);
			blog.setPostedOn(postedOn);
			
			list.add(blog);
		}
		return list;
	}
	
}