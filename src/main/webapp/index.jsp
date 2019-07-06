<%--
  Created by IntelliJ IDEA.
  User: Liwei
  Date: 2015/11/17
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>poi 从模板导出示例</title>
    <%-- 引入 bootstrap 样式表 --%>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>poi 从模板导出示例</h1>

    <!-- ajax 表单提交 -->
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/word/download" id="downloadForm" method="post">
        <div class="form-group">
            <label for="pzjg" class="col-sm-2 control-label">篇章结构：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="pzjg" name="pzjg" placeholder="请输入篇章结构的分数">
            </div>
        </div>
        <div class="form-group">
            <label for="gdnr" class="col-sm-2 control-label">观点内容：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="gdnr" name="gdnr" placeholder="请输入篇章结构的分数">
            </div>
        </div>
        <div class="form-group">
            <label for="jsyy" class="col-sm-2 control-label">句式运用：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="jsyy" name="jsyy" placeholder="请输入篇章结构的分数">
            </div>
        </div>

        <div class="form-group">
            <label for="chyf" class="col-sm-2 control-label">词汇语法：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="chyf" name="chyf" placeholder="请输入篇章结构的分数">
            </div>
        </div>

        <div class="form-group">
            <label for="xzgf" class="col-sm-2 control-label">写作规范：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="xzgf" name="xzgf" placeholder="请输入篇章结构的分数">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">导出数据到 word 文档</button>
            </div>
        </div>
    </form>

</div>

</body>

<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="jquery.form.js"></script>
<script type="text/javascript">

    /**
     * 该例子演示了 jquery.form.js 最基本的用法
     */
    $(document).ready(function() {
        // 一个最最简单的例子
        $('#downloadForm').ajaxForm(function(data) {

        });
    });
</script>
