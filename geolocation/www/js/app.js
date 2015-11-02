// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
angular.module('starter', ['ionic'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
});

angular.module('starter', ['ionic'])
.controller('PopupCtrl',function($scope, $ionicPopup, $timeout) {

// Triggered on a button click, or some other target
$scope.showPopup = function() {
  $scope.data = {}

  // An elaborate, custom popup
  var myPopup = $ionicPopup.show({
    template: '<input type="password" ng-model="data.wifi">',
    title: 'Enter Wi-Fi Password',
    subTitle: 'Please use normal things',
    scope: $scope,
    buttons: [
      { text: 'Cancel' },
      {
        text: '<b>Save</b>',
        type: 'button-positive',
        onTap: function(e) {
          if (!$scope.data.wifi) {
            //don't allow the user to close unless he enters wifi password
            e.preventDefault();
          } else {
            return $scope.data.wifi;
          }
        }
      }
    ]
  });
  myPopup.then(function(res) {
    console.log('Tapped!', res);
  });
  $timeout(function() {
     myPopup.close(); //close the popup after 3 seconds for some reason
  }, 3000);
 };
 // A confirm dialog
 $scope.showConfirm = function() {
   var confirmPopup = $ionicPopup.confirm({
     title: 'Consume Ice Cream',
     template: 'Are you sure you want to eat this ice cream?'
   });
   confirmPopup.then(function(res) {
     if(res) {
       console.log('You are sure');
     } else {
       console.log('You are not sure');
     }
   });
 };

 // An alert dialog
 $scope.showAlert = function() {
   var alertPopup = $ionicPopup.alert({
     title: 'Don\'t eat that!',
     template: 'It might taste good'
   });
   alertPopup.then(function(res) {
     console.log('Thank you for not eating my delicious ice cream cone');
   });
 };
});


// .controller('MainCtrl', function ($cordovaGeolocation, geoLocation, $window, $cordovaDialogs) {
//   $cordovaGeolocation.getCurrentPosition().then(function (position) {
//     geoLocation.setGeolocation(position.coords.latitude, position.coords.longitude);
//     console.log(position.coords.latitude, position.coords.longitude);
//     $window.location.href = 'home.html';
//   }, function (err) {
//     console.log('position error');
//     console.log(err);
//     geoLocation.setGeolocation(28.61, 77.23);
//     $window.location.href = 'err.html';
//    });
// });

// module.controller('MyCtrla', function($scope, $cordovaDialogs) {
//
//   $cordovaDialogs.alert('message', 'title', 'button name')
//     .then(function() {
//       // callback success
//     });
//
//   $cordovaDialogs.confirm('message', 'title', ['button 1','button 2'])
//     .then(function(buttonIndex) {
//       // no button = 0, 'OK' = 1, 'Cancel' = 2
//       var btnIndex = buttonIndex;
//     });
//
//   $cordovaDialogs.prompt('msg', 'title', ['btn 1','btn 2'], 'default text')
//     .then(function(result) {
//       var input = result.input1;
//       // no button = 0, 'OK' = 1, 'Cancel' = 2
//       var btnIndex = result.buttonIndex;
//     });
//
//   // beep 3 times
//   $cordovaDialogs.beep(3);
//
// });
