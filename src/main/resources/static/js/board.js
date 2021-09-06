var main = {

    init : function () {
        var _this = this;

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-board-update').on('click', function () {
            boardId = $(#boardId).val();
            window.location.href = '/board/update/'+boardId;
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('.showArea').on('click', function() {
            _this.dropDown();
        });
    },

    // board-datail 용 dropDown
    dropDown : function () {
        // this가 안먹으면 init dropDown() 부분에 parameter 넣어주기
    	$(this).next('.dropArea').slideToggle(300);
        // +, - 아이콘 바꾸기
        var plus = $(this).children('span').children('.bi-plus-lg');
        var dash = $(this).children('span').children('.bi-dash-lg');

        console.log(plus);
        console.log(dash);

        if ( dash.css('display') == 'none' ) {
            dash.css('display', 'block');
            plus.css('display', 'none');
        } else {
            plus.css('display', 'block');
            dash.css('display', 'none');
        }
    },

    save : function () {

        boardTitle = $('#boardTitle').val();
        userId = $('#userId').val();
        boardContent = $('#boardContent').val();

        if (boardTitle == '' || boardTitle == NULL) {
            alert('제목을 입력하세요');
            return false;
        }

        if (boardContent == '' || boardContent == NULL) {
            alert('내용을 입력하세요');
            return false;
        }

        var data = {
            boardTitle: boardTitle,
            userId: userId,
            boardContent: boardContent
        };

        $.ajax({
            type: 'POST',
            url: '/api/board/',
            dataType: 'json',
            contentType: 'application/json; charset = utf-8'
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/board/boardList';
        }).fail(function() {
            alert(JSON.stringify(error));
            // JSON.stringify() 메서드는 JavaScript 값이나 객체를 JSON 문자열로 변환합니다.
        });

    },

    update : function () {

        boardTitle = $('#boardTitle').val();
        boardContent = $('#boardContent').val();
        boardId = $('#boardId').val();

        if (boardTitle == '' || boardTitle == NULL) {
            alert('수정할 제목을 입력하세요');
            return false;
        }

        if (boardContent == '' || boardContent == NULL) {
            alert('수정할 내용을 입력하세요');
            return false;
        }

        var data = {
            boardTitle: boardTitle,
            userId: userId,
            boardContent: boardContent
        };

        $.ajax({
            type: 'POST',
            url: '/api/board/'+boardId,
            dataType: 'json',
            contentType: 'application/json; charset = utf-8'
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/board/boardList';
        }).fail(function() {
            alert(JSON.stringify(error));
             // JSON.stringify() 메서드는 JavaScript 값이나 객체를 JSON 문자열로 변환합니다.
        });

    },

    delete : function () {
        var boardId = ('#boardId').val();

        if (!confirm("정말 삭제하시겠습니까??")){    //확인
            return false;
        }

        $.ajax({
            type: 'DELETE',
            url: '/api/board/'+boardId,
            dataType: 'json',
            contentType: 'application/json; charset = utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/board/boardList';
        }).fail(function() {
            alert(JSON.stringify(error));
            // JSON.stringify() 메서드는 JavaScript 값이나 객체를 JSON 문자열로 변환합니다.
        });

    }


};

main.init();