const tBody = document.querySelector("tbody")
const urlGetUsers = 'http://localhost:8080/api/users';
let output = ``
const renderTable = (users) => {
    users.forEach((user) => {
        output += `<tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.lastName}</td>
                        <td>${user.age}</td>
                        <td>${user.username}</td>
                        <td>${user.roles[0].name}</td>
                        <td>
                            <button type="button" class="btn btn-info btn-sm" data-bs-toggle="modal"
                                    data-bs-target="#editUser" data-bs-id="${user.id}"
                                    data-bs-firstname="${user.name}" data-bs-lastname="${user.lastName}"
                                    data-bs-age="${user.age}" data-bs-email="${user.username}">
                                edit
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal"
                                    data-bs-target="#deleteUser" data-bs-id="${user.id}"
                                    data-bs-firstname="${user.name}" data-bs-lastname="${user.lastName}"
                                    data-bs-age="${user.age}" data-bs-email="${user.username}">
                                delete
                            </button>
                        </td>
                    </tr>`
    })
    tBody.innerHTML = output
}
window.onload = function() {
showUser()
}
function showUser(){
    output = ``
    fetch(urlGetUsers)
        .then((response) => response.json())
        .then((data) => renderTable(data))
}
function addUser() {
    $("form").submit(function (event) {
        $.ajax({
            type: "POST",
            url: "/api/users",
            data: JSON.stringify({"name":$('#name').val(),"lastName":$('#lastName').val(),"age":$('#age').val(),"username":$('#email').val(),"password":$('#password').val(),"roles":$('#roles').val()}),
            dataType: "json",
            contentType: "application/json; charset=utf-8"
        }).always(function () {
            $('#user-table-tab').click()
            showUser()
        });
        event.preventDefault();
    });
}
function updateUser() {
    $("form").submit(function (event) {
        $.ajax({
            type: "PUT",
            url: "/api/users",
            data: JSON.stringify({"id":$('#editUser #id').val(), "name":$('#editUser #name').val(),"lastName":$('#editUser #lastName').val(),"age":$('#editUser #age').val(),"username":$('#editUser #email').val(),"password":$('#editUser #password').val(),"roles":$('#editUser #roles').val()}),
            dataType: "json",
            contentType: "application/json; charset=utf-8"
        }).always(function () {
            $('#editUser').modal('hide');
            showUser()
        });
        event.preventDefault();
    });
}
function deleteUser() {
    $("form").submit(function (event) {
        $.ajax({
            type: "DELETE",
            url: "/api/users/" + $('#deleteUser #id').val(),
            dataType: "json",
            contentType: "application/json; charset=utf-8"
        }).always(function () {
            $('#deleteUser').modal('hide');
            showUser()
        });
        event.preventDefault();
    });
}