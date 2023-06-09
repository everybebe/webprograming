/**
 * 
 */	

$.replyWriteServer = function(re){
	$.ajax({
		url: `${mypath}/ReplyWrite.do`, 
			type: 'post',
			data: reply, //cont, bonum, name  
			success : function(res){
				//저장성공 
				
				//댓글내용에 출력
				//$(re)
			},
			error : function(xhr) {
				
			},
			dataType : 'json'
		
	})
}

$.boardWriteServer = function(){
	$.ajax({
		url: `${mypath}/BoardWrite.do`, 
			type: 'post',
			data : fdata,
			success : function(res){
				//alert(res.flag);
				if(res.flag =="ok") {
					currentPage = 1;
					$.listPageServer(currentPage);
				}
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			
			dataType : 'json'
		
	})	
}	

				
$.listPageServer = function(cpage){
	
		vtype= $('#stype option:selected').val().trim();
		vword= $('#sword').val().trim();
		
		$.ajax({
			url: `${mypath}/Boardlist.do`, 
			type: 'post',
			data : {
				"page" : cpage,
				"stype" : vtype,
				"sword" : vword
			},
			success : function(res) {
				
				code = `<div class="container mt-3">
				     	<div id="accordion">`;
				
				$.each(res.datas, function(i, v){
					 
				    content = v.content;
					 
					content =  content.replaceAll(/\n/g, "<br>");
					 
					 
				code += `<div class="card">

			      <div class="card-header">
			        <a class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
			          ${v.subject}
			        </a>
			      </div>
			      <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
			        <div class="card-body">
						<p class="p1">
						작성자<span id="wr">${v.writer}</span> &nbsp;&nbsp;&nbsp;  
						이메일<span id="em">${v.mail}</span> &nbsp;&nbsp;&nbsp;
						날짜<span id="da">${v.wdate}</span> &nbsp;&nbsp;&nbsp;  
						조회수<span id="hit">${v.hit}</span> &nbsp;&nbsp;&nbsp;
						</p>
						<p class="p2">
							<input type="button" idx="${v.num}" name="delete" class="action" value="삭제">
							<input type="button" idx="${v.num}" name="modify" class="action" value="수정">
						</p>
						<p class="p3">
						${content}
						</p>
						<p class="p4">
							<textarea rows="" cols="50"></textarea>
							<input type="button" name="reply" idx="${v.num}" class="action" value="등록">
						</p>
			        </div>
			      </div>
			    </div>`
		
				}) //$.each
				
				code += `</div>
						</div>`
				//리스트 출력
				
				$('#result1').html(code);
						
				//페이지 처리
				//이전
				pager = "";
				pager += `<ul class="pagination">`
				if(res.sp > 1) {
					pager += `<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`
	
		
				}
				
				//페이지 번호
				for(i = res.sp; i <= res.ep; i++) {
					if(i == currentPage){
						 pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`
					}else {
						 pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`
					}
					
				}

				//다음
				if(res.ep < res.tp) {

					pager += `<li class="page-item"><a  id="next" class="page-link" href="#">Next</a></li>`
				}
					pager += `</ul>`	
						
					$('#pagelist').html(pager);
						
						
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : 'json'
			
		})

}