var reGexPass = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;

function checkAllData() {
    isValidPass = checkPass();
    isValidCPass = checkPassConfirm();
    isValid = isValidPass && isValidCPass;
    return isValid;
}

function checkPass() {
    pass = $("#password").val();
    if (pass === "") {
        $("#txtPasswordMessage").html("Password cannot be empty!");
    } else if (reGexPass.test(pass) === false) {
        $("#txtPasswordMessage").html("Invalid password!");
    } else {
        $("#txtPasswordMessage").html("");
    }
    return pass !== "" && reGexPass.test(pass);
}

function checkPassConfirm() {
    password = $("#password").val();
    confirm = $("#confirm").val();
    if (confirm === "") {
        $("#txtConfirmMessage").html('Confirm password can not be empty!');
    } else if (confirm === password) {
        $("#txtConfirmMessage").html('');
    } else {
        $("#txtConfirmMessage").html("Confirm password does not match!");
    }
    return confirm === password;
}

$(document).ready(function () {
    $("#password").blur(function () {
        checkPass();
    });

    $("#confirm").blur(function () {
        checkPassConfirm();
    });

    $("#myForm").bind({
        'submit': function () {
            return checkAllData();
        }
    });
});

