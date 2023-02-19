var patt_name = /^[a-zA-Z][a-zA-Z0-9 _ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$/;
var patt_phone = /^0[1-9]\d{8}$/;
var patt_email = /^\w+([\.-_]\w+)*@\w+([\.-_]\w+)*(\.\w{2,3})+$/;
var patt_password = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;

function checkAllData() {
    isValidName = checkName();
    isValidAddress = checkAddress();
    isValidPassword = checkPassword();
    isValid = isValidName && isValidAddress && isValidPassword;
    return isValid;
}

function checkName() {
    fullName = $("#name").val();
    if (fullName === "") {
        $("#txtNameMessage").html("Name can't be empty");
    } else if (patt_name.test(fullName) === false) {
        $("#txtNameMessage").html("Name is invalid");
    } else {
        $("#txtNameMessage").html("");
    }
    return patt_name.test(fullName) && fullName !== "";
}

function checkPhone() {
    phone = $("#phone").val();
    if (phone === "") {
        $("#txtPhoneMessage").html("Phone can't be empty");
    } else if (patt_phone.test(phone) === false) {
        $("#txtPhoneMessage").html("Phone is invalid");
    } else {
        $("#txtPhoneMessage").html("");
    }
    return patt_phone.test(phone) && phone !== "";
}

function checkAddress() {
    address = $("#address").val();
    if (address === "") {
        $("#txtAddressMessage").html("Address can't be empty");
    } else if (patt_name.test(address) === false) {
        $("#txtAddressMessage").html("Address is invalid");
    } else {
        $("#txtAddressMessage").html("");
    }
    return patt_name.test(address) && address !== "";
}

function checkPassword() {
    password = $("#password").val();
    if (password === "") {
        $("#txtPasswordMessage").html("Password can't be empty");
    } else if (patt_password.test(password) === false) {
        $("#txtPasswordMessage").html("Password is invalid");
    } else {
        $("#txtPasswordMessage").html("");
    }
    return patt_password.test(password) && password !== "";
}

$(document).ready(function () {
    $("#name").blur(function () {
        checkName();
    });
    $("#phone").blur(function () {
        checkPhone();
    });
    $("#address").blur(function () {
        checkAddress();
    });
    $("#password").blur(function () {
        checkPassword();
    });
    $("#myForm").bind({
        'submit': function () {
            return checkAllData();
        }
    });
});