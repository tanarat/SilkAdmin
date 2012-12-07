package org.silk.common.dao;

import java.util.List;

import org.silk.common.model.Entrepreneur;

public interface EntrepreneurDao {
	public void save(Entrepreneur entrepreneur);
	public List<Entrepreneur> list();
	public void delete(Long id);
	public Entrepreneur getById(Long id);
}
