/* */
$(document).ready(function () {
    $('#eye').click(function () {
        $(this).chidren('i').toggleClass('fa-solid fa-eye-slash');
    });
});

function showMessageDelete() {
    var result = confirm("Are you sure to delete this user account?");
    if (result) {
        return true;
    } else {
        return false;
    }
}