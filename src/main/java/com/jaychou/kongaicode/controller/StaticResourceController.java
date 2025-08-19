package com.jaychou.kongaicode.controller;

import com.jaychou.kongaicode.constant.AppConstant;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import java.io.File;

@RestController
@RequestMapping("/static")
public class StaticResourceController {

    // 应用生成根目录（用于浏览）
    private static final String PREVIEW_ROOT_DIR = AppConstant.CODE_OUTPUT_ROOT_DIR;


    /**
     * 提供静态资源访问，支持目录重定向
     * 访问格式：http://localhost:8123/api/static/{deployKey}[/{fileName}]
     */
    // 处理GET请求，匹配路径模式：/{deployKey}/**（包含任意子路径）
    @GetMapping("/{deployKey}/**")
    public ResponseEntity<Resource> serveStaticResource(
            @PathVariable String deployKey,  // 从URL路径中提取deployKey变量
            HttpServletRequest request) {    // 注入HTTP请求对象
        try {
            // 获取完整的请求路径（例如：/static/key123/css/style.css）
            String resourcePath = (String) request.getAttribute(
                    HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

            // 截取实际资源路径：去掉"/static/"前缀和deployKey部分
            // 例如：/static/key123/css/style.css → /css/style.css
            resourcePath = resourcePath.substring(("/static/" + deployKey).length());

            // 处理目录请求（路径为空，例如访问/static/key123）
            if (resourcePath.isEmpty()) {
                HttpHeaders headers = new HttpHeaders();
                // 添加Location头，重定向到带斜杠的URL（SEO友好做法）
                headers.add("Location", request.getRequestURI() + "/");
                // 返回301永久重定向
                return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
            }

            // 处理根路径请求（例如/static/key123/）
            if (resourcePath.equals("/")) {
                // 默认返回index.html（SPA常见做法）
                resourcePath = "/index.html";
            }

            // 构建实际文件系统路径（PREVIEW_ROOT_DIR可能是类路径或绝对路径）
            // 例如：/var/www/preview/key123/css/style.css
            String filePath = PREVIEW_ROOT_DIR + "/" + deployKey + resourcePath;
            File file = new File(filePath);

            // 文件不存在时返回404
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 将文件包装为Spring Resource对象
            Resource resource = new FileSystemResource(file);

            // 返回200响应，并自动设置：
            // 1. Content-Type（根据文件扩展名）
            // 2. Content-Length（自动计算）
            // 3. 支持断点续传（Range头处理）
            return ResponseEntity.ok()
                    // 设置正确的Content-Type和字符集（如text/html;charset=UTF-8）
                    .header("Content-Type", getContentTypeWithCharset(filePath))
                    .body(resource);
        } catch (Exception e) {
            // 捕获所有异常，避免暴露内部错误信息
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 根据文件扩展名返回带字符编码的 Content-Type
     */
    private String getContentTypeWithCharset(String filePath) {
        if (filePath.endsWith(".html")) return "text/html; charset=UTF-8";
        if (filePath.endsWith(".css")) return "text/css; charset=UTF-8";
        if (filePath.endsWith(".js")) return "application/javascript; charset=UTF-8";
        if (filePath.endsWith(".png")) return "image/png";
        if (filePath.endsWith(".jpg")) return "image/jpeg";
        return "application/octet-stream";
    }
}
