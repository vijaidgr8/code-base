resource "local_file" "Variables" {
  content  = var.is_content ? "Hello Vijai" : "Bye Vijai"
  filename = "${path.module}/vijai.txt"
}