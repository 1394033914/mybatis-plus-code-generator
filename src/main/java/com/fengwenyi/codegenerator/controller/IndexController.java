package com.fengwenyi.codegenerator.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.codegenerator.Config;
import com.fengwenyi.codegenerator.service.IIndexService;
import com.fengwenyi.codegenerator.util.FileUtil;
import com.fengwenyi.codegenerator.vo.CodeGeneratorRequestVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="https://www.fengwenyi.com">tymyjmac</a>
 * @since 2021-07-12
 */
@Controller
@RequestMapping("/")
public class IndexController {

  private static final String SUFFIX = "_code.zip";

  @Autowired
  private IIndexService indexService;

  public String index() {
    return "index";
  }

  @PostMapping("/code-generator")
  @ResponseBody
  public ResultTemplate<Void> codeGenerator(@RequestBody @Validated CodeGeneratorRequestVo requestVo) {
      return indexService.codeGenerator(requestVo);
  }

  // public ResultTemplate<Void> codeGenerator(@RequestBody @Validated CodeGeneratorRequestVo requestVo, HttpServletResponse response) {
  //   // 删除目录
  //   FileUtil.delete(Config.OUTPUT_DIR);
  //   ResultTemplate<Void> result = indexService.codeGenerator(requestVo);
  //   // 打包
  //   String zipFile = System.currentTimeMillis() + SUFFIX;
  //   // try {
  //     // FileUtil.compress(Config.OUTPUT_DIR, zipFile);
  //     // // 下载
  //     // FileUtil.download(zipFile, Config.PROJECT_PATH, false, response);

  //   // } catch (IOException e) {
  //   //   e.printStackTrace();
  //   // } catch (Exception e) {
  //   //   e.printStackTrace();
  //   // }
  //   return result;
  // }

}
