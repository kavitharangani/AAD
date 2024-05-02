// $("#save_item").click(function () {
//     let formData = {
//         item_code: $("#item_id").val(),
//         item_name: $("#item_name").val(),
//         item_description: $("#item_description").val(),
//         item_price: $("#item_price").val(),
//         item_qty: $("#item_qty").val(),
//     };
//
//     $.ajax({
//         method: "POST",
//         url: "http://localhost:8080/shop/api/v1/item",
//         contentType: "application/json",
//         data: JSON.stringify(formData),
//         success: function (data) {
//             reset();
//             alert("Item saved successfully.");
//         },
//         error: function (xhr, status, error) {
//             alert("Error: " + error);
//         }
//     });
// });
//
// $("#update_item").click(function () {
//     let formData = {
//         item_code: $("#item_id").val(),
//         item_name: $("#item_name").val(),
//         item_description: $("#item_description").val(),
//         item_price: $("#item_price").val(),
//         item_qty: $("#item_qty").val(),
//     };

//     $.ajax({
//         method: "PATCH",
//         url: "http://localhost:8080/shop/api/v1/item",
//         contentType: "application/json",
//         data: JSON.stringify(formData),
//         success: function (data) {
//             reset();
//             alert("Item updated successfully.");
//         },
//         error: function (xhr, status, error) {
//             alert("Error updating item: " + error);
//         }
//     });
// });

$(document).ready(function (){
    // Save customer
    $("#save_item").click(function () {
        let formData = {
            item_code: $("#item_id").val(),
            item_name: $("#item_name").val(),
            item_description: $("#item_description").val(),
            item_price: $("#item_price").val(),
            item_qty: $("#item_qty").val(),
        };

        $.ajax({
            method: "POST",
            url: "http://localhost:8080/shop/api/v1/item",
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function (data) {
                reset();
                alert("Item saved successfully.");
            },
            error: function (xhr, status, error) {
                alert("Error: " + error);
            }
        });
    });

    // Update customer
    $("#update_item").click(function (){
        let formData = {
            item_code: $("#item_id").val(),
            item_name: $("#item_name").val(),
            item_description: $("#item_description").val(),
            item_price: $("#item_price").val(),
            item_qty: $("#item_qty").val(),
        };

        $.ajax({
            method: "PATCH",
            url: "http://localhost:8080/shop/api/v1/item",
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function (data) {
                reset();
                alert("Item updated successfully.");
            },
            error: function (xhr, status, error) {
                alert("Error: " + error);
            }
        });
    });

    // Delete customer
    $("#delete_item").click(function () {
        let item_id = $("#item_id").val();

        $.ajax({
            method: "DELETE",
            url: "http://localhost:8080/shop/api/v1/item/" + item_id,
            success: function (data) {
                reset();
                alert("Item deleted successfully.");
            },
            error: function (xhr, status, error) {
                alert("Error: " + error);
            }
        });
    });

    // Reset form
    $("#item_reset").click(function () {
        reset();
    });

    // Reset function
    function reset() {
        $("#item_id").val("");
        $("#item_name").val("");
        $("#item_description").val("");
        $("#item_price").val("");
        $("#item_qty").val("");
    }

});
