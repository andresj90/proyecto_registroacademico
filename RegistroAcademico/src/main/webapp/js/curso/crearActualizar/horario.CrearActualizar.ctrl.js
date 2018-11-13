/* global horario */

var HorarioModule = angular.module('HorarioModule');

HorarioModule.controller('crearHorarioCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;

        $scope.horario = {};

        if (id) {
            $http.get('api/horarios/' + id).then(function (response) {
                $scope.horario = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearHorario = function () {
            if ($scope.horario.dia && $scope.horario.hora_inicio && horario.hora_finalizacion) {
                $http.post('api/horarios', JSON.stringify($scope.horario)).then(function (response) {
                    //Reinicia la vaariable
                    $scope.horario = {};
                    // Nombre de la ruta definida en routes
                    $state.go('crearActualizarHorario');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarProducto = function(){
            if ($scope.horario.dia && $scope.horario.hora_inicio && horario.hora_finalizacion) {
                $http.put('api/horarios/'+id, JSON.stringify($scope.horario)).then(function(response){
                    //Reinicia la vaariable
                    $scope.horario = {};
                    // Nombre de la ruta definida en routes
                    $state.go('crearActualizarHorario');
                }, function(error){
                    console.log(error);
                });
            }
        };
    }]);


