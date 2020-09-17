package dao;

import java.util.List;

import domain.Image;

public interface ImageDao {

	public List<Image> findAll() throws Exception;

	public List<Image> findPart(Image image) throws Exception;

	public Image findById(Integer id) throws Exception;

	public void insert(Image image) throws Exception;

	public void update(Image image) throws Exception;

	public void delete(Image image) throws Exception;



}
