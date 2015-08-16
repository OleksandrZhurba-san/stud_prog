function deleteStudents() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Please select students");
        return;
    }
    var ids = "";
    for ( var i = 0; i < items.length; i++) {
        ids += $(items[i]).attr("id");
        if (i < items.length - 1) {
            ids += ",";
        }
    }

    console.log(ids);
    console.log("ids=" + ids);
    var form = '<form id="deleteStudentForm" action="student_remove" method="post"><input type="hidden" name="ids" /></form>';
    $("body").append(form);
    $('#deleteStudentForm input').val(ids);
    $('#deleteStudentForm').submit();
}
