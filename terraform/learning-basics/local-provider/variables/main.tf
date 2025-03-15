resource "local_file" "Variables" {
  content  = "${var.file_content}"
  filename = "${path.module}/vijai.txt"
}