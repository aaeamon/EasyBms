package org.eamon.web;

import com.alibaba.fastjson.JSON;
import org.eamon.bean.Brand;
import org.eamon.bean.PageBean;
import org.eamon.bean.PageParam;
import org.eamon.service.BrandService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Brand brand = JSON.parseObject(req.getInputStream(), Brand.class);
        BrandService brandService = new BrandService();
        int row = brandService.insert(brand);
        resp.getWriter().write(row == 1 ? "success" : "fail");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int[] ids = JSON.parseObject(req.getInputStream(), int[].class);
        System.out.println(Arrays.toString(ids));
        BrandService brandService = new BrandService();
        int row = brandService.delete(ids);
        resp.getWriter().write(row == ids.length ? "success" : "fail");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Brand brand = JSON.parseObject(req.getInputStream(), Brand.class);
        BrandService brandService = new BrandService();
        int row = brandService.update(brand);
        resp.getWriter().write(row == 1 ? "success" : "fail");
    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        //调用service
        BrandService brandService = new BrandService();
        List<Brand> list = brandService.showAll();
        //转json返回
        String json = JSON.toJSONString(list);
        resp.getWriter().write(json);
    }

    private void pagination(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        PageParam pageParam = JSON.parseObject(req.getInputStream(), PageParam.class);
        BrandService brandService = new BrandService();
        PageBean pageBean = brandService.pagination(pageParam);
        String json = JSON.toJSONString(pageBean);
        resp.getWriter().write(json);
    }
}


