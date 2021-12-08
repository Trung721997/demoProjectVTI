$(function() {
    var isRememberMe = storage.getRememberMe();
    document.getElementById("rememberMe").checked = isRememberMe;
});

function login() {
    // Get username & password
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var confirm = document.getElementById("confirm_password").value;

    // validate
    if (!username) {
        showNameErrorMessage("Please input username!");
        return;
    }

    if (!password) {
        showNameErrorMessage("Please input password!");
        return;
    }

    if (!confirm) {
        showNameErrorMessage("Please input confirm password!");
        return;
    }

    // validate username 6 -> 30 characters
    if (username.length < 6 || username.length > 50 || password.length < 6 || password.length > 50) {
        // show error message
        showNameErrorMessage("Password or username Wrong  Try Again   ");
        return;
    }

    if (password != confirm) {
        alert("Password not Matching")
        return;
    }

    // Call API
    $.ajax({
        url: 'http://localhost:8080/api/v1/login',
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
        },
        success: function(data, textStatus, xhr) {
            // save data to storage
            // https://www.w3schools.com/html/html5_webstorage.asp
            // save remember me
            var isRememberMe = document.getElementById("rememberMe").checked;
            storage.saveRememberMe(isRememberMe);

            // save data
            storage.setItem("ID", data.id);
            storage.setItem("FULL_NAME", data.fullName);
            storage.setItem("ROLE", data.role);
            storage.setItem("USERNAME", username);
            storage.setItem("PASSWORD", password);


            // redirect to home page
            // https://www.w3schools.com/howto/howto_js_redirect_webpage.asp
            window.location.replace("http://127.0.0.1:5501/html/program.html");
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 401) {
                showNameErrorMessage("Login fail!");
            } else {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });
}

function showNameErrorMessage(message) {
    document.getElementById("errorMessage").style.display = "block";
    document.getElementById("errorMessage").innerHTML = message;
}

function hideNameErrorMessage() {
    document.getElementById("errorMessage").style.display = "none";
}




// form login =====================================



$(document).ready(function() {
    $('.login-info-box').fadeOut();
    $('.login-show').addClass('show-log-panel');
});

$('.login-reg-panel input[type="radio"]').on('change', function() {
    if ($('#log-login-show').is(':checked')) {
        $('.register-info-box').fadeOut();
        $('.login-info-box').fadeIn();

        $('.white-panel').addClass('right-log');
        $('.register-show').addClass('show-log-panel');
        $('.login-show').removeClass('show-log-panel');

    } else if ($('#log-reg-show').is(':checked')) {
        $('.register-info-box').fadeIn();
        $('.login-info-box').fadeOut();

        $('.white-panel').removeClass('right-log');

        $('.login-show').addClass('show-log-panel');
        $('.register-show').removeClass('show-log-panel');
    }
});


// Key code  Enter Login ==========================



var input = document.getElementById("username");
var input = document.getElementById("password");
var input = document.getElementById("confirm_password");
input.addEventListener("keyup", function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
        document.getElementById("login").click();
    }
});



// Confirm-- Password ======================================




$('#password, #confirm_password').on('keyup', function() {
    if ($('#password').val() == $('#confirm_password').val()) {
        $('#errorMessage-confirm').html('Matching').css('color', 'green');
    } else
        $('#errorMessage-confirm').html('Not Matching').css('color', 'red');
});