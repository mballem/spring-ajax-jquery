$(document).ready(function () {

    $('#saveContact').submit(function (e) {

        $.post('/spring-ajax/contact/save', $(this).serialize(), function(contact) {
            $('#contactTableResponse').last().append(
                '<tr>' +
                    '<td>' + contact.id + '</td>' +
                    '<td>' + contact.firstName + '</td>' +
                    '<td>' + contact.lastName + '</td>' +
                    '<td>' + contact.age + '</td>' +
                '</tr>'
            );
        });

        clearInputs();

        e.preventDefault();
    });

});

function clearInputs() {
    $('input[id*="Input"]').each(function () {
        $(this).val('');
    });
}

$(document).ready(function () {
    $('#button').click(function () {

        var first = $('#firstInput').val();
        var last = $('#lastInput').val();

        $.ajax({
            type:'GET',
            url:"/spring-ajax/contact/getJSON/" + first + "/" + last,
            dataType:'json',
            success:function (result) {

                var contact =
                    "id : " + result.id +
                    " | name : " + result.firstName + " " + result.lastName +
                    " | age : " + result.age;

                $("#theJson").html(contact);
                
                clearInputs();

            },
            error:function (jqXHR, textStatus, errorThrown) {
                alert("Contact " + textStatus + " " + errorThrown + " !");
            }

        });
    });
});

$(document).ready(function () {
    $('#search').keyup(function (e) {
        var filter = $('#search').val();
        if (filter.length > 0) {
            loadTable(filter);
        } else {
            $('tr[id*="tr_"]').remove();
        }
    });
});

function loadTable(filter) {
    var url = "/spring-ajax/contact/load/" + filter;

    $('#tbody').load(url, function (response, status, xhr) {
        if (status == "error") {
            var msg = "Sorry but there was an error: ";
            $("#info").html(msg + xhr.status + " " + xhr.statusText);
        }
    });

    return false;
}
