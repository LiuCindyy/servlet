<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>鏄撹喘鈥斺�攍ogin</title>
    <link type="text/css" href="css/login.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="pic">
    <div>
        <ul>
            <li class="index"><a href="">棣栭〉</a></li>
            <li class="yonghu"><a href="">鐢ㄦ埛</a></li>
            <li class="shopping"><a href="">鍟嗗搧鍒嗙被</a></li>
            <li class="dingdan"><a href="">璁㈠崟</a></li>
            <li class="shopX"><a href="">鍟嗗搧璇︾粏</a></li>
            <li class="gonggao"><a href="">鍏憡</a></li>
        </ul>
    </div>
    </div>
    <div class="TiShi">管理员你好，今天的日期是<%=new java.util.Date()%>锛屾杩庢潵鍒拌礉澹斥�㈡槗璐晢鍩庡悗鍙扮鐞嗙郴缁熴��</div>
    <div class="address">鎮ㄧ幇鍦ㄧ殑浣嶇疆锛�<a href="#" target="_parent" > 璐濆３鏄撹喘鈥㈠晢鍩�</a> &gt; 鍚庡彴绠＄悊</div>
</header>
<center>
<div>
	
    <article>
        <section class="top">
        <ul>
            <li></li>
            <li><span>&nbsp;&nbsp;绠＄悊棣栭〉</span></li>
        </ul></section>
        <div class="line"></div>
        <section class="bottom">
            <section class="top">娆㈣繋鐧诲綍鏄撹喘鈥㈠晢鍩庣郴缁�</section>
</center>            
            <form action="LoginServlet" method="post" name="login">
            <section class="middle">
                    <table>
                    
                    	<tr>
                    		<td></td>
                            <td style="color:red"></td>
                        	 <td></td>
                    	</tr>
                        <tr>
                            <td>鐢ㄦ埛鍚嶏細</td>
                            <td><input type="text" name="userName" value="admin1" onfocus="gogo('userName')" onblur="checkName()"></td>
                        	 <td id="resuName"></td>
                        </tr>
                        <tr>
                            <td>鐧诲綍瀵嗙爜锛�</td>
                            <td><input type="password" name="pwd" value="123456" ></td>
                        	 <td id="resuPwd"></td>
                        </tr>
                        
                       <tr> <td></td> 
                       <td><input type="image" src="images/login.gif" onclick="return checkAll()" ></td>   <td></td></tr>      
                    </table>

            </section>
            </form>
        </section>
    </article>
</div>

<footer>
    <div>
        <div class="footer_top">
            <ul>
                <li>鍙嬫儏閾炬帴锛�</li>
                <li><a href="">鐧惧害</a>|</li>
                <li><a href="">Google</a>|</li>
                <li><a href="">闆呰檸</a>|</li>
                <li><a href="">娣樺疂</a>|</li>
                <li><a href="">鎷嶆媿</a>|</li>
                <li><a href="">鏄撹叮</a>|</li>
                <li><a href="">褰撳綋</a>|</li>
                <li><a href="">浜笢鍟嗗煄</a>|</li>
                <li><a href="">杩呴浄</a>|</li>
                <li><a href="">鏂版氮</a>|</li>
                <li><a href="">缃戞槗</a>|</li>
                <li><a href="">鎼�&nbsp;鐙�</a>|</li>
                <li><a href="">鐚墤</a>|</li>
                <li><a href="">寮�蹇冪綉</a>|</li>
                <li><a href="">鏂板崕缃�</a>|</li>
                <li><a href="">鍑ゅ嚢缃�</a></li>
            </ul>
        </div>
        <div class="middle">
            <div class="line2"></div>
            <ul>
                <li>CORYRIGHT鈥�2014-2015鍖椾含甯傝礉澹斥�㈡槗璐晢鍩庢湁闄愬叕鍙革紙鍖椾含鍒嗛儴锛� ALL RIGHT RESERVED</li>
                <li>鍗庡畤浜掕仈锛堝寳浜垎閮級鐮斿彂閮�</li>
                <li>鐑嚎锛�400-88-1388 Email:service@ibochy.com.cn</li>
                <li>ICP:浜琁CP澶�02121211</li>
            </ul>
        </div>
        <div class="footer_bottom">
          <img src="images/img1.gif"><img src="images/img2.gif">
            <img src="images/img3.gif">
            <img src="images/img4.gif">
        </div>
    </div>
</footer>
</body>
</html>