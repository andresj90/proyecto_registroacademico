var coordinadorModule = angular.module('coordinadorModule');

coordinadorModule.controller('coordinadorCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;
        
        $scope.coordinador = {}; 
        
        
        if (id) {
            $http.get('api/coordinadores/' + id).then(function (response) {
             $scope.coordinador = response.data;
            }, function (error) {
                console.log(error);
            });
        }


         $scope.registrarCoordinador = function () {
            
           if ($scope.coordinador.nombres && $scope.coordinador.apellidos && $scope.coordinador.genero
                && $scope.coordinador.email && $scope.coordinador.tipo_documento_id &&  $scope.coordinador.nro_documento) {
                        $http.post('api/coordinadores', JSON.stringify($scope.coordinador)).then(function (response) {
                        $scope.coordinador = {}; 
                        $state.reload();
                
            },function(error) {
              console.log(error);
              });
            }
        }; 
         
         
         //list tipe of documents 
         
         $scope.tiposDocumentos = new Array(); 
         $http.get('api/tipodocumentos').then(function (response) {
                
                $scope.tiposDocumentos = response.data; 
            }, function (error) {
                console.log(error);
            });
      


         //update a coordinator 
         
         $scope.actualizarCoordinador = function () {
            if ($scope.coordinador.nombres && $scope.coordinador.apellidos && $scope.coordinador.genero
                && $scope.coordinador.email && $scope.coordinador.tipo_documento_id &&  $scope.coordinador.nro_documento) {
                $http.put('api/coordinadores/'+id, JSON.stringify($scope.coordinador)).then(function (response) {
                    $scope.coordinador = {}; 
                    $state.go();
                }, function (error) {
                    
                    console.log(error);
                });
            }   
         };
        
    }]); 