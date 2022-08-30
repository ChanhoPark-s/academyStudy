<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../taglib.jsp" %>
    
<style>
	.err{
		color: red;
		font-size: 8;
		font-weight: bolder;
	}
</style>

<script type="text/javascript">

var f_selbox = new Array('아시아','아프리카','유럽','아메리카','오세아니아');

var s_selbox = new Array();
s_selbox[0] = new Array('한국','중국','베트남','네팔');
s_selbox[1] = new Array('케냐', '가나', '세네갈');
s_selbox[2] = new Array('스페인', '영국','덴마크','러시아','체코');
s_selbox[3] = new Array('미국', '캐나다'); 
s_selbox[4] = new Array('뉴질랜드','오스트레일리아');

function firstChange(f){
	//alert(2);
	var f_sel = f.continent; // 대륙
	var s_sel = f.nation; // 나라
	
	f_index = f_sel.selectedIndex;
	f_val = f_sel[f_index].value;
	alert(f_index+"/"+f_val);// 1/아시아  2/아프리카
	
	for(var i=s_sel.length;i>0;i--){
		s_sel.options[i+1] = null;
	}
	
	for(var i=0;i<s_selbox[f_index-1].length;i++){
		s_sel.options[i+1] = new Option(s_selbox[f_index-1][i]); 
	}
}//firstChange
</script>

<%
	String[] continentList = { "아시아","아프리카","유럽","아메리카","오세아니아" };

	String[][] nationList = {
								{"한국","중국","베트남","네팔"},
								{"케냐", "가나", "세네갈"},
								{"스페인", "영국","덴마크","러시아","체코"},
								{"미국", "캐나다"},
								{"뉴질랜드","오스트레일리아"}			
					 		};

%>

<c:set var="cList" value="<%=continentList %>"/>
<c:set var="nList" value="<%=nationList %>"/>

<form:form commandName="movie" method="post" action="update.mv" name="f">
	<input type="hidden" name="num" value="${movie.num }">
	<input type="hidden" name="pageNumber" value="${pageNumber }">
	<h1><span>영화 정보 등록 화면</span></h1>
	<p>
		<label for="title">영화 제목 : </label>
		
		<input type="text" name="title" id="title" value="${movie.title }">
		<form:errors cssClass="err" path="title" />
	</p>
	<p style="float:left">
		<label for="continent" style="float:left;">대륙 : </label>
		<select name = "continent" id="continent" style="width: 130px;" onchange="firstChange(this.form,'${cList }','${nList }')" >
			<option value="">대륙 선택하세요</option> 
			<c:forEach var="i" begin="0" end="${fn:length(cList)-1 }">
				<option value="${cList[i]}" <c:if test="${cList[i] eq movie.continent }">selected</c:if>>${cList[i]}
			</c:forEach>
			
		</select>
		<form:errors cssClass="err" path="continent" />
	</p>
	
	
	<p style="float:left">
		<label for="nation"> &nbsp;&nbsp;&nbsp;나라 : </label>
		<select name = "nation" id="nation" style="width: 130px;">
			<option value="">나라 선택하세요</option> 
			<c:forEach var="i" begin="0" end="${fn:length(cList)-1 }">
			<c:if test="${cList[i] eq movie.continent }">
				<c:forEach var="j" begin="0" end="${fn:length(nList[i])-1 }">
					<option value="${nList[i][j]}" <c:if test="${nList[i][j] eq movie.nation }">selected </c:if>>${nList[i][j]}
				</c:forEach>
			</c:if>
		</c:forEach>
			
		</select>
		<form:errors cssClass="err" path="nation" />
	</p>
	<p  style="clear:left">
		<label for="genre">장르 : </label>
		<input type="checkbox" name="genre" id="genre" value="액션" <c:if test="${fn:contains(movie.genre,'액션') }"> checked </c:if>>액션
		<input type="checkbox" name="genre" id="genre" value="스릴러" <c:if test="${fn:contains(movie.genre,'스릴러') }"> checked </c:if>>스릴러
		<input type="checkbox" name="genre" id="genre" value="코미디" <c:if test="${fn:contains(movie.genre,'코미디') }"> checked </c:if>>코미디
		<input type="checkbox" name="genre" id="genre" value="판타지" <c:if test="${fn:contains(movie.genre,'판타지') }"> checked </c:if>>판타지
		<input type="checkbox" name="genre" id="genre" value="애니메이션" <c:if test="${fn:contains(movie.genre,'애니메이션') }"> checked </c:if>>애니메이션
		<form:errors cssClass="err" path="genre" />
	</p>
	<p>
		<label for="grade">등급 : </label>
		<input type="radio" name="grade" id="grade" value="19" <c:if test="${movie.grade eq 19}"> checked </c:if>>19
		<input type="radio" name="grade" id="grade" value="15" <c:if test="${movie.grade eq 15}"> checked </c:if>>15
		<input type="radio" name="grade" id="grade" value="12" <c:if test="${movie.grade eq 12}"> checked </c:if>>12
		<input type="radio" name="grade" id="grade" value="7" <c:if test="${movie.grade eq 7}"> checked </c:if>>7
		<form:errors cssClass="err" path="grade" />
	</p>
	
	 <p>
		<label for="actor">출연 배우 : </label>
		<input type="text" name="actor" id="actor" value="${movie.actor }">
		<form:errors cssClass="err" path="actor" />
	</p>
	<p >
		<input type="submit" value="수정하기" id="btnSubmit">		
	</p>
</form:form>

