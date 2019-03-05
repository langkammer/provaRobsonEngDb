;(function() {

	'use strict';

	/**
	 * @description
	 * # request
	 * Service que faz o controle das chamadas dos servidos no backend.
	 */
	angular.module('App').service('request', function ($http) {
		var blockConfig = {
			message: '<i class="fa fa-spinner fa-spin fa-5x fa-fw margin-bottom load"></i>',
			css: {
				border:         '0',
				backgroundColor:'transparent'
			}
		};

		function BlockUtil(element){

			this.block = function(){
				if(element){
					element.block(blockConfig);
				}else{
					$.blockUI(blockConfig);
				}
			};

			this.unBlock = function(){
				if(element){
					element.unblock();
				}else{
					$.unblockUI();
				}
			};
		}

		/**
		 * JSON Headers
		 */

		var config = {
			headers: {
				'Content-type': 'application/json; charset=utf8',
				'Accept': 'application/json',
				'Cache-Control': 'no-cache',
				'X-Request': 'JSON',
				'Access-Control-Allow-Origin': '*',
				'Access-Control-Allow-Headers': 'Content-Type,X-Requested-With',
				'Access-Control-Allow-Methods': 'GET'
			}
		};

		var baseURL = '/';

		/**
		 * Configuracação dos metodos de request
		 */
		var request = {};


		request.post = function (servico, parameter, callback) {

			var block = new BlockUtil();

			block.block();

			var http = $http.post(servico, JSON.stringify(parameter), config)
				.then(
                    function successCallback(data){
					    callback(data);
                    }
                    ,
                    function errorCallback(data, status){

                      var _message = 'Erro ao chamar a url ' + _url + ' status ' + status;

                      callback(data);

                      console.log(_message);
                    }

				);

			http['finally'](function(){

				block.unBlock();

			});

		};


		request.get = function (url, successCallback, errorCallback) {

			var block = new BlockUtil();

			block.block();

			var http = $http.get(url, config.headers).then(
				function success(data){

					successCallback(data.data);
				}
				, function error(data, status){

					var _message = 'Erro ao chamar a url ' + url + ' status ' + status;

					console.log(_message);

					errorCallback(data.data);
				});


			http['finally'](function(){

				block.unBlock();

			});

		};

		return request;

	});//fim service

})();