<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/common/header.jsp">
    <jsp:param name="title" value="파라미터테스트"/>
</jsp:include>
<section id="content">
    <h3>파라미터 테스트</h3>
    <form id="devFrm" method="post">
        <div class="form-group row">
            <label for="devName" class="col-sm-2 col-form-label">이름</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="devName" name="devName">
            </div>
        </div>
        <div class="form-group row">
            <label for="devAge" class="col-sm-2 col-form-label">나이</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="devAge" name="devAge">
            </div>
        </div>
        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="devEmail" name="devEmail">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">성별</label>
            <div class="col-sm-10">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="devGender" id="devGender0" value="M">
                    <label class="form-check-label" for="devGender0">남</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="devGender" id="devGender1" value="F">
                    <label class="form-check-label" for="devGender1">여</label>
                </div>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">개발언어</label>
            <div class="col-sm-10">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="devLang" id="devLang0" value="Java">
                    <label class="form-check-label" for="devLang0">Java</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="devLang" id="devLang1" value="C">
                    <label class="form-check-label" for="devLang1">C</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="devLang" id="devLang2" value="Javascript">
                    <label class="form-check-label" for="devLang2">Javascript</label>
                </div>
            </div>
        </div>
        <div class="form-group row">
            <label for="birthDay" class="col-sm-12  col-from-label">
                생일
            </label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="birthDay" name="birthDay">
            </div>
        </div>
        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">우편번호</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="zipCode" name="zipCode">
            </div>
        </div>
        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">시도</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sido" name="sido">
            </div>
        </div>
        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">군구</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="gungu" name="gungu">
            </div>
        </div>
        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">동</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="dong" name="dong">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="requestTest('demo1.do')">
                    서블릿처럼 매핑메소드 이용하기
                </button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="requestTest('demo2.do')">
                    서블릿처럼 매핑메소드 이용하기
                </button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="requestTest('demo3.do')">
                    @RequestParam 이용하기
                </button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="requestTest('demo4.do')">
                    DTO객체 이용하기
                </button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="requestTest('demo5.do')">
                    Map객체 이용하기
                </button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="requestTest('demo6.do')">
                    추가정보 확인
                </button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="requestTest('demo7.do')">
                    Model and View 응답
                </button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="ajaxTest('demo8.do')">
                    객체응답하기
                </button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button type="button" class="btn btn-outline-primary col-sm-12"
                        onclick="requestTest('demo9.do')">
                    custom view 응답하기
                </button>
            </div>
        </div>
    </form>
</section>
<script>
    const requestTest=(url)=>{
        const form=document.getElementById("devFrm");
        form.action='${pageContext.request.contextPath}/demo/'+url;
        form.submit();
    }
    const ajaxTest=(url)=>{
        fetch("${pageContext.request.contextPath}/demo/"+url,{
            method:"post",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                devName:"이난희",
                devAge:28,
                devGender:"여",
                devEmail:"nan@nan.late",
                devLang:["java","javascript"]
            })
        })
            .then(response=>response.json())
            .then(data=>{console.log(data);});
    }
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
