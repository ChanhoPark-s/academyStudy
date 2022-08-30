<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file= "../../taglib.jsp" %>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<%-- <c:set var="path" value="<%=request.getContextPath() %>"/> --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<script type="text/javascript" src="${path}/resources/js/jquery.js"></script>
<script type="text/javascript">
	
	var f_selbox = new Array('아시아', '아프리카', '유럽', '아메리카', '오세아니아');

	var s_selbox = new Array();
	s_selbox[0] = new Array('한국', '중국', '베트남', '네팔');
	s_selbox[1] = new Array('케냐', '가나', '세네갈');
	s_selbox[2] = new Array('스페인', '영국', '덴마크', '러시아', '체코');
	s_selbox[3] = new Array('미국', '캐나다');
	s_selbox[4] = new Array('뉴질랜드', '오스트레일리아');

	function init(f,mc,mn){
		
		//alert(mc+"/"+mn);
		//alert(m.continent.value);
		
		for(var i=0;i<f_selbox.length;i++){
			f.continent.options[i+1] = new Option(f_selbox[i]); // options 옵션 (이름,value)
			
			if(f.continent.options[i+1].value == mc){
				f.continent.options[i+1].selected = true;
			}
		}
		
	}//init
	
	function firstChange(f){
		//alert(1);
		
		var f_sel = f.continent; // 대륙 변수 넣은것
		var s_sel = f.nation;//나라 셀렉스 값 넣은것
		
		f_index = f_sel.selectedIndex;
		f_val = f_sel[f_index].value;
		
		for(var i=s_sel.length;i>0;i--){
				s_sel.options[i+1] = null // 지워야함 넣기전에
		}
		
		for(var i=0;i<s_selbox[f_index-1].length;i++){ // 넣기
			s_sel.options[i+1] = new Option(s_selbox[f_index-1][i]);
		}
	}// firstChange
	
	
	$(document).ready(function(){
		//alert(11);
		
		var isCheck = false;
		var isChange = false;
		var use;
		
		$('#title_check').click(function() {
			//alert(3);
			isCheck = true;
			
			$.ajax({
				url : "title_check_proc.mv",
				data : ({
					inputtitle : $("input[name='title']").val()
				}),
				success : function(data){
					if ($('input[name="title"]').val() == "") {
						$('#titleMessage').html("<font color=red>title입력 누락</font>");
						$('#titleMessage').show();
					}

					else if(data=='YES'){
						$('#titleMessage').html("<font color=red>사용 가능합니다.</font>");
						$('#title_e').hide();
						$('#titleMessage').show();
						use = "possible";
						isChange= false;
					}
					else{
						$('#titleMessage').html("<font color=red>이미 등록한 제목입니다.</font>");
						$('#title_e').hide();
						$('#titleMessage').show();
						use = "impossible";
					}
				}//success
			}); // ajax
		}); // click

		$('input[name="title"]').keydown(function(){
			$('#title_e').hide();
			$('#titleMessage').css('display','none');
			isChange = true;
			use = "";
		});
		
		$('#btnSubmit').click(function(){
			
			if(use == "impossible" ){
				alert('이미 사용중인 제목입니다.');
				return false;
			}
			else if(isCheck== false || isChange == true){
				alert("중복체크를 하세요");
				return false;
			}
		});//click
		
		
		
		
	});//ready
	
	
	
</script>
<style>
	.e{
		font-weight: bold;
		color: red;
	}

</style>
<body onload="init(f,'${m.continent}','${m.nation }')"><!-- form 정보를 넘긴다. -->
<form:form commandName="m" method="post"  action="insert.mv" name="f">
	<h1><span>영화 정보 등록 화면</span></h1>
	<p>
		<label for="title">영화 제목 : </label>
		<input type="text" name="title" id="title" value="${m.title }">
		<input type="button" id="title_check" value="중복체크">
		<span id="titleMessage" style="display: none;"></span>
		<form:errors cssClass="e" path="title" id="title_e"/>
	</p>
	<p style="float:left">
		<label for="continent" style="float:left;">대륙 : </label>
		<select name = "continent" id="continent" style="width: 130px;" onchange="firstChange(this.form)"> <!--폼 이름 넘기거나 this.form  -->
			<option value="">대륙 선택하세요</option> 
		</select>
		<form:errors cssClass="e" path="continent"/>
	</p>
	
	<p  style="float:left">
		<label for="nation"> &nbsp;&nbsp;&nbsp;나라 : </label>
		<select name = "nation" id="nation" style="width: 130px;">
			<option value="">나라 선택하세요</option> 
		</select>
		<form:errors cssClass="e" path="nation"/>
	</p>
	
	<p  style="clear:left">
		<label for="genre">장르 : </label>
		<input type="checkbox" name="genre" id="genre" value="액션" <c:if test="${fn:contains(m.genre,'액션') }">checked</c:if>>액션
		<input type="checkbox" name="genre" id="genre" value="스릴러" <c:if test="${fn:contains(m.genre,'스릴러') }">checked</c:if>>스릴러
		<input type="checkbox" name="genre" id="genre" value="코미디" <c:if test="${fn:contains(m.genre,'코미디') }">checked</c:if>>코미디
		<input type="checkbox" name="genre" id="genre" value="판타지" <c:if test="${fn:contains(m.genre,'판타지') }">checked</c:if>>판타지
		<input type="checkbox" name="genre" id="genre" value="애니메이션" <c:if test="${fn:contains(m.genre,'애니메이션') }">checked</c:if>>애니메이션
		<form:errors cssClass="e" path="genre"/>
	</p>
	
	<p>
		<label for="grade">등급 : </label>
		<input type="radio" name="grade" id="grade" value="19" <c:if test="${m.grade eq '19' }">checked</c:if>>19
		<input type="radio" name="grade" id="grade" value="15" <c:if test="${m.grade eq '15' }">checked</c:if>>15
		<input type="radio" name="grade" id="grade" value="12" <c:if test="${m.grade eq '12' }">checked</c:if>>12
		<input type="radio" name="grade" id="grade" value="7" <c:if test="${m.grade eq '7' }">checked</c:if>>7
		<form:errors cssClass="e" path="grade"/>
	</p>
	
	 <p>
		<label for="actor">출연 배우 : </label>
		<input type="text" name="actor" id="actor" value="${m.actor }" >
		<form:errors cssClass="e" path="actor"/>
	</p>
	<p >
			<a href= "list.mv">목록보기</a>		
			<input type="submit" value="추가하기" id="btnSubmit">		
	</p>
</form:form>

</body>
