var main = {

    init : function () {
        var _this = this;

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },

    save : function () {
        // 작성해야됨
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