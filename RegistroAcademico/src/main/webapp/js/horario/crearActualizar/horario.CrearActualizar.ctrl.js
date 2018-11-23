var horarioModule = angular.module('horarioModule'); 


horarioModule.controller('horarioCtrl' , ['$scope', '$http', '$state', function ($scope, $http, $state) {
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
            if ($scope.horario.dia && $scope.horario.horarioInicio && $scope.horario.horarioFinalizacion) {
                $http.post('api/horarios', JSON.stringify($scope.horario)).then(function (response) {
                    //Reinicia la vaariable
                    $scope.horario = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarHorarios');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarHorario = function () {
            
            if ($scope.horario.dia && $scope.horario.horarioInicio && $scope.horario.horarioFinalizacion) {
                
                   $http.put('api/horarios/' + id ,JSON.stringify($scope.horario)).then(function (response) {
                   $scope.horario = {}; 
                   $state.go('listarHorarios');
                
            }, function (error) {
                    
                    console.log(error);
               });  
            }
        };
        
 

   
    }]);


