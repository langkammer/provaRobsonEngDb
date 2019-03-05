'use strict';

angular.module('App').controller('ClienteCtrl', function($scope,$state,Services,Notification) {

        init();

        $scope.listar = function(){
            list();
        }

        $scope.abreModal = function(o,tipoCrud){
            $scope.tipoCrud = tipoCrud;
            listaVendedores();
            if(tipoCrud == 'add'){
                $('#modalCliente').modal('show');
                $scope.cliente = {};
            }
            else{
                $('#modalCliente').modal('show');
                $scope.cliente = angular.copy(o);
            }

        }

        $scope.confirm = function(formItem){
            if($scope.tipoCrud == 'add'){
                if(validForm(formItem))
                    save()
            }
            if($scope.tipoCrud == 'edit'){
                if(validForm(formItem))
                    edit()
            }
            if($scope.tipoCrud == 'remove'){
                remove();
            }
        }

        function listaVendedores(){
        Services.listVendedor(function (data) {
            if (data.data.status == 'ERRO') {
                Notification.error(data.data.menssage);
            } else {
                $scope.vendedores = data.data;
            }
        });
        }

        function save(){
         Services.createCliente($scope.cliente , function (data) {
                       if (data.data.status == 'ERRO') {
                           Notification.error(data.data.menssage);
                       } else {
                          Notification.success(data.data.menssage);
                          init();
                       }
           });

        }

        function list(){
             Services.listCliente(function (data) {
                    if (data.status == 'ERRO') {
                        Notification.error(data.menssage);
                    } else {
                        $scope.lista = data.data;
                    }
            });

        }


        function remove(){
            if(confirm("Tem Certeza que deseja deltar este registro ?")){
                Services.deleteCliente($scope.cliente.id,function (data) {
                        if (data.status == 'ERRO') {
                            Notification.error(data.menssage);
                        } else {
                           init();
                        }
                    });
            }
            else{
                init();
            }
        }

        function edit(){
            save();
        }

        function validForm(formItem){
            $scope.submitted = true;
            if(formItem.$invalid){
              Notification.error("Verifique os campos em vermelho");
              return false;
            }
            else {
              return true;
            }



        }

        function init(){
            $scope.submitted = false;
            console.log("Iniciando Controller Cliente ");
            $('#modalCliente').modal('hide');
            $scope.cliente = {};
            $scope.lista = [];
            $scope.tipoCrud = '';
            list();
        }
});