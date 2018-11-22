var app = angular.module('RegistroAcademico');

app.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) { 
       
        //Otherwise - control 404
        $urlRouterProvider.otherwise('/');
        
        //Por cada ruta se crea un nuevo estado
        
       
        
         $stateProvider.state("crearActualizarHorario", {
           url: '/horario' ,
           views:{
               mainView: {
                   templateUrl: 'js/horario/crearActualizar/CrearHorario.html',
                   controller: 'horarioCtrl'
               }
           }
        });
        

        
        $stateProvider.state("listarHorarios", {
           url: '/' ,
           views:{
               mainView: {
                   templateUrl: 'js/horario/listar/ListarHorario.html',
                   controller: 'listarHorarioCtrl'
               }
           }
        });
        
        
        $stateProvider.state("editarHorarios", {
           url: '/horarios/:id' ,
           views: {
               
               mainView :{
                  templateUrl: 'js/horario/crearActualizar/CrearHorario.html',
                  controller : 'horarioCtrl' 
               
               }
           }
            
        }); 

}]); 