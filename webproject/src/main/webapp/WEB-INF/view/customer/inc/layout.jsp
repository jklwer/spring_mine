<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%><!-- tiles의 태그라이브러리 -->
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title><tiles:getAsString name="title"/></title>
    
    <link href="/css/customer/layout.css" type="text/css" rel="stylesheet" />
    <style>
    
        #visual .content-container{	
            height:inherit;
            display:flex; 
            align-items: center;
            
            background: url("../../images/customer/visual.png") no-repeat center;
        }
    </style>
</head>

<body>
    <!-- header 부분 -->

    <header id="header">
        
        <div class="content-container">
	<!-- ---------------------------<header>--------------------------------------- -->
	<tiles:insertAttribute name="header"/>
	
	<!-- --------------------------- <visual> --------------------------------------- -->
	<tiles:insertAttribute name="visual"/>

	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

	<!-- --------------------------- aside --------------------------------------- -->
	<tiles:insertAttribute name="aside"/>
			
	<!-- --------------------------- main --------------------------------------- -->
	<tiles:insertAttribute name="body"/>


			
		</div>
	</div>

    <!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer"/>


    </body>
    
    </html>