'use strict';

angular.module('App').controller('VendedorCtrl', function($scope,$state,Services,Notification) {

        init();

        $scope.abreModal = function(o,tipoCrud){
            $scope.tipoCrud = tipoCrud;
            if(tipoCrud == 'add'){
                $('#modalVendedor').modal('show');
                $scope.vendedor = {};
            }
            else{
                $('#modalVendedor').modal('show');
                $scope.vendedor = angular.copy(o);
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

        function save(){
            Services.createVendedor($scope.vendedor , function (data) {
               if (data.data.status == 'ERRO') {
                   Notification.error(data.data.menssage);
               } else {
                  Notification.success(data.data.menssage);
                  init();
               }
           });

        }

        function list(){
            Services.listVendedor(function (data) {
                if (data.data.status == 'ERRO') {
                    Notification.error(data.data.menssage);
                } else {
                    $scope.lista = data.data;
                }
            });
        }


        function remove(){
            alert("ESTE DADO SERÁ DELETADO");
            if(confirm("Tem Certeza que deseja deltar este registro ?")){
                Services.deleteVendedor($scope.vendedor.id,function (data) {
                    if (data.status == 'ERRO') {
                        Notification.error(data.data.menssage);
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
            Services.createVendedor($scope.vendedor , function (data) {
               if (data.data.status == 'ERRO') {
                   Notification.error(data.data.menssage);
               } else {
                  Notification.success(data.data.menssage);
                  init();
               }
           });
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
            console.log("Iniciando Controller Vendedor ");
            $('#modalVendedor').modal('hide');
            $scope.vendedor = {};
            $scope.lista = [];
            $scope.tipoCrud = '';
            list();
        }
});