resource "local_file" "Count" {
    count = length(var.file_content)
    content = "This is the content of the file ${var.file_content[count.index]}"
    filename = "${path.module}/${var.file_content[count.index]}"
}