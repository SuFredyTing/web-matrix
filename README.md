# Web-Matrix #

## Projects ##

- **eureka_register_service**

	It is responsible for the registration of all services.

- **router**

	It is the interface of all services. The user can submit two matrices to the system through it. After the system is calculated, it also interacts with the user.

- **Matrix**

	It is responsible for the calculation of the matrix, that is, the matrix calculation is divided into the calculation of the vector.

- **Vector**

	It is responsible for accepting two vectors from the Matrix and doing the corresponding operations, and the result is returned to the Matrix.

## How to run ##

```shell
# load images from compressed files
sudo docker load < register.tar
sudo docker load < router.tar 
sudo docker load < matrix.tar
sudo docker load < vector.tar

# run container, each contianer launching must have 5 seconds interval
sudo docker run -d --net=host register
sleep 5
sudo docker run -d --net=host router
sleep 5
sudo docker run -d --net=host matrix
sleep 5
sudo docker run -d --net=host vector 
```

Visit [http://127.0.0.1](http://127.0.0.1) to enter application.

Visit [http://127.0.0.1](http://127.0.0.1:8000) to enter web monitor.

Choose two matrix txt files and submit, the format of file is listed as following:

1 2 3

4 5 6

7 8 9

We have provide some of files in this project for test.

## Docker Image ##

**链接：**[http://pan.baidu.com/s/1dE7demt ](http://pan.baidu.com/s/1dE7demt )

**密码：** lqpj
