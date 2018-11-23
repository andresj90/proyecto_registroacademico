/* global tipocurso */

var ProgramaModule = angular.module('ProgramaModule');

ProgramaModule.controller('crearProgramaCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;
        
       $scope.convertirAPalabra = function (dato){
                
                return dato.toString();
       }


        $scope.Programa = {};

        if (id) {
            $http.get('api/programas/' + id).then(function (response) {
                $scope.Programa = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearPrograma = function () {
            console.log($scope.Programa);
            if ($scope.Programa.nombrePrograma) {
                $http.post('api/programas', JSON.stringify($scope.Programa)).then(function (response) {
                    console.log(response.data);
                    //Reinicia la vaariable
                    $scope.Programa = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarPrograma');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarPrograma = function(){
            if ($scope.Programa.nombre) {
                $http.put('api/programas/'+id, JSON.stringify($scope.Programa)).then(function(response){
                    //Reinicia la vaariable
                    $scope.Programa = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarPrograma');
                }, function(error){
                    console.log(error);
                });
            }
        };
    }]);


