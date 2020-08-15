resource "aws_instance" "test" {
    ami           = "ami-0c1ee26e489972734"
    instance_type = "t2.micro"
}

