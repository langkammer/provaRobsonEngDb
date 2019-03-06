/**
 */
;(function() {

  'use strict';

  /**
   * @description
   */
  angular.module('App').service('Services', function (request) {
    return {
      listCliente: function (data,successCallback, errorCallback) {
        request.post('cliente/listar',data, successCallback, errorCallback);
      },
      createCliente: function (successCallback, errorCallback) {
        request.post('cliente/create', successCallback, errorCallback);
      },
      getCliente: function (id,successCallback, errorCallback) {
        request.get('cliente/get/'+id, successCallback, errorCallback);
      },
      deleteCliente : function (id,successCallback, errorCallback) {
        request.get('cliente/delete/'+id, successCallback, errorCallback);
      },
      listVendedor: function (successCallback, errorCallback) {
        request.get('vendedor/listar', successCallback, errorCallback);
      },
      createVendedor: function (obj,successCallback, errorCallback) {
        request.post('vendedor/create',obj, successCallback, errorCallback);
      },
      getVendedor: function (id,successCallback, errorCallback) {
        request.get('vendedor/get/'+id, successCallback, errorCallback);
      },
      deleteVendedor : function (id,successCallback, errorCallback) {
        request.get('vendedor/delete/'+id, successCallback, errorCallback);
      }
    };//fim return

  });//fim service

})();
