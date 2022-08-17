package org.eamon.service;

import org.apache.ibatis.session.SqlSession;
import org.eamon.bean.Brand;
import org.eamon.bean.PageBean;
import org.eamon.bean.PageParam;
import org.eamon.dao.BrandDao;
import org.eamon.utils.SqlSessionUtil;

import java.util.List;

public class BrandService {
    //查询所有
    public List<Brand> showAll(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        BrandDao dao = sqlSession.getMapper(BrandDao.class);
        List<Brand> list = dao.showAll();
        sqlSession.close();
        return list;
    }
    public int insert(Brand brand){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        BrandDao dao = sqlSession.getMapper(BrandDao.class);
        int row = dao.insert(brand);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }
    public int update(Brand brand){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        BrandDao dao = sqlSession.getMapper(BrandDao.class);
        int row = dao.update(brand);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }
    public int delete(int[] ids){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        BrandDao dao = sqlSession.getMapper(BrandDao.class);
        int row = dao.delete(ids);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }
    public PageBean pagination(PageParam pageParam){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        BrandDao dao = sqlSession.getMapper(BrandDao.class);
        int offset = (pageParam.getCurrentPage() - 1) * pageParam.getPageSize();
        List<Brand> list = dao.pagination(offset, pageParam);
        int totalBrands = dao.totalBrands(pageParam);
        sqlSession.close();
        return new PageBean(totalBrands,list);
    }
}
