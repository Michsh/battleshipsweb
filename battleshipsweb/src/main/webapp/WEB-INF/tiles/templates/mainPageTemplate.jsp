<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><tiles:getAsString name="title"/></title>
        <link rel="stylesheet" type="text/css" href="mainPageTemplate.css"/>
    </head>
    <body>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        
        <div id="box">
            
            <div id="upper">
                
                <tiles:insertAttribute name="upper"/>
                
            </div>
            
            <div id="left">
                
                <tiles:insertAttribute name="left"/>
                
            </div>
            
            <div id="center">
                
                <tiles:insertAttribute name="center"/>
                
            </div>
            
        </div>
        
    </body>
</html>