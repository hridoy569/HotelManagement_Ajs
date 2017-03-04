var app = angular.module("myApp", ['ui.bootstrap', 'ngResource']);
            app.controller("guestBctrl", function ($scope, $http) {
                $scope.guestDetail = {};
                $scope.guests = [];
                $scope.messege = "";
                $scope.guestForm = {
                    BookingNo: -1,
                    Title: "",
                    Name: "",
                    Gender: "",
                    Nationality: "",
                    PassportNo: "",
                    VisaNo: "",
                    RAddress: "",
                    PhoneNo: "",
                    Email: "",
                    RoomNo: "",
                    DateOfArival: "",
                    DateOfDeparture: "",
                    BookingForDays: "",
                    NoOfPerson: "",
                    Relationship: "",
                    CheckedStatus: "auto",
                    BookingDate: "auto",
//                    countryName: "",
//                    population: "",
                    myVar: true
                };

                //Now load the data from server
                _refreshGuestData();
                
                //HTTP POST/PUT methods for add/edit country 
                // with the help of id, we are going to find out whether it is put or post operation
                $scope.submitGuest = function () {
                    
                   
                    var method = "";
                    var url = "";
                    if ($scope.guestForm.BookingNo === -1) {
                        //Id is absent in form data, it is create new country operation
                        method = "POST";
                        url = 'rest/guestBooking';
                        $scope.messege = "Data submitted successfully!";
                    } else {
                        //Id is present in form data, it is edit country operation
                        method = "PUT";
                        url = 'rest/guestBooking';
                        $scope.messege = "Data updated successfully!";
                    }
                    $http({
                        method: method,
                        url: url,
                        data: angular.toJson($scope.guestForm),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(_success, _error);
                    
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, 
                    function(){
                        $(this).remove();
                        clearMessage();
                            });
                    }, 2000);
                };
                
                //HTTP DELETE- delete country by Id
                $scope.deleteGuest = function (x) {
                    $scope.messege = "Guest deleted successfully!";
                    $http({
                        method: 'DELETE',
                        url: 'rest/guestBooking/' + x.BookingNo
                    }).then(_success, _error);
                    
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, 
                    function(){
                        $(this).remove();
                        clearMessage();
                            });
                    }, 2000);
                };
                
                // In case of edit, populate form fields and assign form.id with country id
                $scope.editGuest = function (x) {

                    $scope.guestForm.Title = x.Title;
                    $scope.guestForm.Name = x.Name;
                    $scope.guestForm.Gender = x.Gender;
                    $scope.guestForm.Nationality = x.Nationality;
                    $scope.guestForm.PassportNo = x.PassportNo;
                    $scope.guestForm.VisaNo = x.VisaNo;
                    $scope.guestForm.RAddress = x.RAddress;
                    $scope.guestForm.PhoneNo = x.PhoneNo;
                    $scope.guestForm.Email = x.Email;
                    $scope.guestForm.RoomNo = x.RoomNo;
                    $scope.guestForm.DateOfArival = x.DateOfArival;
                    $scope.guestForm.DateOfDeparture = x.DateOfDeparture;
                    $scope.guestForm.BookingForDays = x.BookingForDays;
                    $scope.guestForm.NoOfPerson = x.NoOfPerson;
                    $scope.guestForm.Relationship = x.Relationship;
                    $scope.guestForm.CheckedStatus = x.CheckedStatus;
                    $scope.guestForm.BookingDate = x.BookingDate;
                    $scope.guestForm.BookingNo = x.BookingNo;
                    
                    $scope.messege = "Information added to form for updating!";
                    
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, 
                    function(){
                        $(this).remove();
                        clearMessage();
                            });
                    }, 2000);
                    
                };
                
                $scope.checkedIn = function (x) {
                    $scope.messege = "Checked In successfully!";
                    $http({
                        method: 'PUT',
                        url: 'rest/checkedin/' + x.RoomNo
                    }).then(_success, _error);
                    
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, 
                    function(){
                        $(this).remove();
                        clearMessage();
                            });
                    }, 2000);
                };
                
                $scope.checkedOut = function (x) {
                    $scope.messege = "Checked Out successfully!";
                    $http({
                        method: 'PUT',
                        url: 'rest/checkedout/' + x.RoomNo
                    }).then(_success, _error);
                    
                    window.setTimeout(function() {
                        $(".alert").fadeTo(500, 0).slideUp(500, 
                    function(){
                        $(this).remove();
                        clearMessage();
                            });
                    }, 2000);
                };

                /* Private Methods */
                //HTTP GET- get all countries collection
                function _refreshGuestData() {
                    $http({
                        method: 'GET',
                        url: 'rest/guestBooking'
                    }).then(function successCallback(response) {
                        $scope.guests = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }

                function _success(response) {
                    _refreshGuestData();
                    _clearFormData();
                    console.log("Console is OK")
                }
                
                $scope.reload = function () {
                    _refreshGuestData();
                };

                function _error(response) {
                    console.log(response.statusText);
                }

                //Clear the form
                function _clearFormData() {
                    $scope.guestForm.BookingNo = -1;
                    $scope.guestForm.Title = "";
                    $scope.guestForm.Name = "";
                    $scope.guestForm.Gender = "";
                    $scope.guestForm.Nationality = "";
                    $scope.guestForm.PassportNo = "";
                    $scope.guestForm.VisaNo = "";
                    $scope.guestForm.RAddress = "";
                    $scope.guestForm.PhoneNo = "";
                    $scope.guestForm.Email = "";
                    $scope.guestForm.RoomNo = "";
                    $scope.guestForm.DateOfArival = "";
                    $scope.guestForm.DateOfDeparture = "";
                    $scope.guestForm.BookingForDays = "";
                    $scope.guestForm.NoOfPerson = "";
                    $scope.guestForm.Relationship = "";
                    $scope.guestForm.CheckedStatus = "auto";
                    $scope.guestForm.BookingDate = "auto";
                    

                };
                
                $scope.selectGuest= function(x){
                    $scope.guestDetail=x;
                };
                
                $scope.clearMessage = function(){
		$scope.messege = "";
                };
                
                $scope.current= "Checked In";
                $scope.future= "Not Yet";
                $scope.archived= "Checked Out";
                
                // For pagination
                $scope.totalItems = $scope.guests.length;
                $scope.currentPage = 1;
                $scope.numPerPage = 5;

                $scope.paginate = function(value) {
                  var begin, end, index;
                  begin = ($scope.currentPage - 1) * $scope.numPerPage;
                  end = begin + $scope.numPerPage;
                  index = $scope.guests.indexOf(value);
                  return (begin <= index && index < end);
                }; // For pagination
            });
            
            app.controller("serviceController", function ($scope, $http) {
                $scope.services = [];
                $scope.serviceForm = {
                    id: -1,
                    Breakfast: "",
                    Lunch: "",
                    Dinner: "",
                    Laundary: "",
                    Telephone: "",
                    Gym: "",
                    SwimmingPool: "",
                    TotalServiceCharge: "",
                    BookingNo: "",
//                    ServiceDate
                    myVar: true
                };

                //Now load the data from server
                _refreshCountryData();
                //HTTP POST/PUT methods for add/edit country 
                // with the help of id, we are going to find out whether it is put or post operation
                $scope.submitS = function () {
                    var method = "";
                    var url = "";
                    if ($scope.serviceForm.id == -1) {
                        //Id is absent in form data, it is create new country operation
                        method = "POST";
                        url = 'rest/services';
                    } else {
                        //Id is present in form data, it is edit country operation
                        method = "PUT";
                        url = 'rest/services';
                    }
                    $http({
                        method: method,
                        url: url,
                        data: angular.toJson($scope.serviceForm),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(_success, _error);
                };

                //HTTP DELETE- delete country by Id
                $scope.deleteService = function (s) {
                    $http({
                        method: 'DELETE',
                        url: 'rest/services/' + s.id
                    }).then(_success, _error);
                };

                // In case of edit, populate form fields and assign form.id with country id
                $scope.editService = function (s) {

                    $scope.serviceForm.Breakfast = s.Breakfast;
                    $scope.serviceForm.Lunch = s.Lunch;
                    $scope.serviceForm.Dinner = s.Dinner;
                    $scope.serviceForm.Laundary = s.Laundary;
                    $scope.serviceForm.Telephone = s.Telephone;
                    $scope.serviceForm.Gym = s.Gym;
                    $scope.serviceForm.SwimmingPool = s.SwimmingPool;
                    $scope.serviceForm.TotalServiceCharge = s.TotalServiceCharge;
                    $scope.serviceForm.BookingNo = s.BookingNo;
                    $scope.serviceForm.id = s.id;
                };

                /* Private Methods */
                //HTTP GET- get all countries collection
                function _refreshCountryData() {
                    $http({
                        method: 'GET',
                        url: 'rest/services'
                    }).then(function successCallback(response) {
                        $scope.services = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }

                function _success(response) {
                    _refreshCountryData();
                    _clearFormData()
                }

                function _error(response) {
                    console.log(response.statusText);
                }

                //Clear the form
                function _clearFormData() {
                    $scope.serviceForm.id = -1;
                    $scope.serviceForm.Breakfast = "";
                    $scope.serviceForm.Lunch = "";
                    $scope.serviceForm.Dinner = "";
                    $scope.serviceForm.Laundary = "";
                    $scope.serviceForm.Telephone = "";
                    $scope.serviceForm.Gym = "";
                    $scope.serviceForm.SwimmingPool = "";
                    $scope.serviceForm.TotalServiceCharge = "";
                    $scope.serviceForm.BookingNo = "";

                }
                ;
                $scope.updateTotal = function() {
                $scope.serviceForm.TotalServiceCharge = $scope.serviceForm.Breakfast + $scope.serviceForm.Lunch+
                                                        $scope.serviceForm.Dinner+$scope.serviceForm.Laundary+
                                                        $scope.serviceForm.Telephone+$scope.serviceForm.Gym+
                                                        $scope.serviceForm.SwimmingPool;
                }
            });
            
app.controller("billCtrl", function ($scope, $http) {
                $scope.bills = [];
                $scope.billForm = {
                    BillNo: -1,
                    BillEntryDate: "",
                    BookingNo: "",
                    BillingDays: "",
                    TotalRoomRent: "",
                    ServiceCharge: "",
                    GrossBillAmount: "",
                    ServiceTax: "",
                    DiscountAllowed: "",
                    NetBillAmount: "",
                    BillingMode: "", 
                    CardNumber: "",
                    AmountRecived: "",
                    OutstandingAmount: "",
                    myVar: true
                };

                //Now load the data from server
                _refreshBillingData();
                //HTTP POST/PUT methods for add/edit country 
                // with the help of id, we are going to find out whether it is put or post operation
                $scope.submitBill = function () {
                    var method = "";
                    var url = "";
                    if ($scope.billForm.BillNo == -1) {
                        //Id is absent in form data, it is create new country operation
                        method = "POST";
                        url = 'rest/bills';
                    } else {
                        //Id is present in form data, it is edit country operation
                        method = "PUT";
                        url = 'rest/bills';
                    }
                    $http({
                        method: method,
                        url: url,
                        data: angular.toJson($scope.billForm),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(_success, _error);
                };

                //HTTP DELETE- delete country by Id
                $scope.deleteBill = function (b) {
                    $http({
                        method: 'DELETE',
                        url: 'rest/bills/' + b.BillNo
                    }).then(_success, _error);
                };

                // In case of edit, populate form fields and assign form.id with country id
                $scope.editBill = function (b) {

                    $scope.billForm.BillEntryDate = b.BillEntryDate;
                    $scope.billForm.BookingNo = b.BookingNo;
                    $scope.billForm.BillingDays = b.BillingDays;
                    $scope.billForm.TotalRoomRent = b.TotalRoomRent;
                    $scope.billForm.ServiceCharge = b.ServiceCharge;
                    $scope.billForm.GrossBillAmount = b.GrossBillAmount;
                    $scope.billForm.ServiceTax = b.ServiceTax;
                    $scope.billForm.DiscountAllowed = b.DiscountAllowed;
                    $scope.billForm.NetBillAmount = b.NetBillAmount;
                    $scope.billForm.CardNumber = b.CardNumber;
                    $scope.billForm.BillingMode = b.BillingMode;
                    $scope.billForm.AmountRecived = b.AmountRecived;
                    $scope.billForm.OutstandingAmount = b.OutstandingAmount;
                    
                    $scope.billForm.BillNo = b.BillNo;
                };

                /* Private Methods */
                //HTTP GET- get all countries collection
                function _refreshBillingData() {
                    $http({
                        method: 'GET',
                        url: 'rest/bills'
                    }).then(function successCallback(response) {
                        $scope.bills = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }

                function _success(response) {
                    _refreshBillingData();
                    _clearFormData();
                }

                function _error(response) {
                    console.log(response.statusText);
                }

                //Clear the form
                function _clearFormData() {
                    $scope.billForm.BillNo = -1;
                    $scope.billForm.BillEntryDate = "";
                    $scope.billForm.BookingNo = "";
                    $scope.billForm.BillingDays = "";
                    $scope.billForm.TotalRoomRent = "";
                    $scope.billForm.ServiceCharge = "";
                    $scope.billForm.GrossBillAmount = "";
                    $scope.billForm.ServiceTax = "";
                    $scope.billForm.DiscountAllowed = "";
                    $scope.billForm.NetBillAmount = "";
                    $scope.billForm.CardNumber = "";
                    $scope.billForm.BillingMode = "";
                    $scope.billForm.AmountRecived = "";
                    $scope.billForm.OutstandingAmount = "";

                }
                ;
            }); 
            
app.controller("billHCtrl", function ($scope, $http) {
                $scope.bills = [];
                

                //Now load the data from server
                _refreshBillingData();
                //HTTP POST/PUT methods for add/edit country 
                // with the help of id, we are going to find out whether it is put or post operation
                
                //HTTP DELETE- delete country by Id
                $scope.deleteBill = function (b) {
                    $http({
                        method: 'DELETE',
                        url: 'rest/billhistory/' + b.BillNo
                    }).then(_success, _error);
                };

                // In case of edit, populate form fields and assign form.id with country id
                

                /* Private Methods */
                //HTTP GET- get all countries collection
                function _refreshBillingData() {
                    $http({
                        method: 'GET',
                        url: 'rest/billhistory'
                    }).then(function successCallback(response) {
                        $scope.bills = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }

                function _success(response) {
                    _refreshBillingData();
                    _clearFormData();
                }

                function _error(response) {
                    console.log(response.statusText);
                }

                
            });
app.controller("roomController", function ($scope, $http) {
                $scope.rooms = [];
                $scope.roomForm = {
                    RoomNo: -1,
                    RoomType: "",
                    RoomRent: "",
                    Status: "",
                    myVar: true
                };

                //Now load the data from server
                _refreshRoomData();
                //HTTP POST/PUT methods for add/edit country 
                // with the help of id, we are going to find out whether it is put or post operation
                $scope.submitRoom = function () {
                    var method = "";
                    var url = "";
                    if ($scope.roomForm.RoomNo == -1) {
                        //Id is absent in form data, it is create new country operation
                        method = "POST";
                        url = 'rest/rooms';
                    } else {
                        //Id is present in form data, it is edit country operation
                        method = "PUT";
                        url = 'rest/rooms';
                    }
                    $http({
                        method: method,
                        url: url,
                        data: angular.toJson($scope.roomForm),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(_success, _error);
                };

                //HTTP DELETE- delete country by Id
                $scope.deleteRoom = function (r) {
                    $http({
                        method: 'DELETE',
                        url: 'rest/rooms/' + r.RoomNo
                    }).then(_success, _error);
                };

                // In case of edit, populate form fields and assign form.id with country id
                $scope.editRoom = function (r) {

                    $scope.roomForm.RoomType = r.RoomType;
                    $scope.roomForm.RoomRent = r.RoomRent;
                    $scope.roomForm.Status = r.Status;
                    $scope.roomForm.RoomNo = r.RoomNo;
                };

                /* Private Methods */
                //HTTP GET- get all countries collection
                function _refreshRoomData() {
                    $http({
                        method: 'GET',
                        url: 'rest/rooms'
                    }).then(function successCallback(response) {
                        $scope.rooms = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }

                function _success(response) {
                    _refreshRoomData();
                    _clearFormData()
                }
                
                $scope.reload = function () {
                    _refreshRoomData();
                };
                
                function _error(response) {
                    console.log(response.statusText);
                }

                //Clear the form
                function _clearFormData() {
                    $scope.roomForm.RoomNo = -1;
                    $scope.roomForm.RoomType = "";
                    $scope.roomForm.RoomRent = "";
                    $scope.roomForm.Status = "";

                }
                ;
            });
app.controller("adminctrl", function ($scope, $http) {
                $scope.admins = [];
                $scope.adminForm = {
                    Id: -1,
                    Name: "", 
                    UserName: "", 
                    Password: "", 
                    Role: "", 
                    ImageUrl: "",
//                    countryName: "",
//                    population: "",
                    myVar: true
                };

                //Now load the data from server
                _refreshAdminData();
                //HTTP POST/PUT methods for add/edit country 
                // with the help of id, we are going to find out whether it is put or post operation
                $scope.submitAdmin = function () {
                    var method = "";
                    var url = "";
                    if ($scope.adminForm.Id == -1) {
                        //Id is absent in form data, it is create new country operation
                        method = "POST";
                        url = 'rest/admins';
                    } else {
                        //Id is present in form data, it is edit country operation
                        method = "PUT";
                        url = 'rest/admins';
                    }
                    $http({
                        method: method,
                        url: url,
                        data: angular.toJson($scope.adminForm),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(_success, _error);
                };

                //HTTP DELETE- delete country by Id
                $scope.deleteAdmin = function (x) {
                    $http({
                        method: 'DELETE',
                        url: 'rest/admins/' + x.Id
                    }).then(_success, _error);
                };

                // In case of edit, populate form fields and assign form.id with country id
                $scope.editAdmin = function (x) {

                    $scope.adminForm.Name = x.Name;
                    $scope.adminForm.UserName = x.UserName;
                    $scope.adminForm.Password = x.Password;
                    $scope.adminForm.Role = x.Role;
                    $scope.adminForm.ImageUrl = x.ImageUrl;
                    $scope.adminForm.Id = x.Id;
                };

                /* Private Methods */
                //HTTP GET- get all countries collection
                function _refreshAdminData() {
                    $http({
                        method: 'GET',
                        url: 'rest/admins'
                    }).then(function successCallback(response) {
                        $scope.admins = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }

                function _success(response) {
                    _refreshAdminData();
                    _clearFormData()
                }

                function _error(response) {
                    console.log(response.statusText);
                }

                //Clear the form
                function _clearFormData() {
                    $scope.adminForm.Id = -1;
                    $scope.adminForm.Name = "";
                    $scope.adminForm.UserName = "";
                    $scope.adminForm.Password = "";
                    $scope.adminForm.Role = "";
                    $scope.adminForm.ImageUrl = "";

                }
                ;
            });
app.controller("todoctrl", function ($scope, $http) {
                $scope.todos = [];
                $scope.todoForm = {
                    id: -1,
                    Actions: "",
                    Date: "",
                    Time: "",
                    myVar: true
                };

                //Now load the data from server
                _refreshTodoData();
                //HTTP POST/PUT methods for add/edit country 
                // with the help of id, we are going to find out whether it is put or post operation
                $scope.submitTodo = function () {
                    var method = "";
                    var url = "";
                    if ($scope.todoForm.id == -1) {
                        //Id is absent in form data, it is create new country operation
                        method = "POST";
                        url = 'rest/todos';
                    } else {
                        //Id is present in form data, it is edit country operation
                        method = "PUT";
                        url = 'rest/todos';
                    }
                    $http({
                        method: method,
                        url: url,
                        data: angular.toJson($scope.todoForm),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(_success, _error);
                };

                //HTTP DELETE- delete country by Id
                $scope.deleteTodo = function (t) {
                    $http({
                        method: 'DELETE',
                        url: 'rest/todos/' + t.id
                    }).then(_success, _error);
                };

                // In case of edit, populate form fields and assign form.id with country id
                $scope.editTodo = function (t) {

                    $scope.todoForm.Actions = t.Actions;
                    $scope.todoForm.Date = t.Date;
                    $scope.todoForm.Time = t.Time;
                    $scope.todoForm.id = t.id;
                };

                /* Private Methods */
                //HTTP GET- get all countries collection
                function _refreshTodoData() {
                    $http({
                        method: 'GET',
                        url: 'rest/todos'
                    }).then(function successCallback(response) {
                        $scope.todos = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }

                function _success(response) {
                    _refreshTodoData();
                    _clearFormData()
                }

                function _error(response) {
                    console.log(response.statusText);
                }

                //Clear the form
                function _clearFormData() {
                    $scope.todoForm.id = -1;
                    $scope.todoForm.Actions = "";
                    $scope.todoForm.Date = "";
                    $scope.todoForm.Time = "";
                    

                }
                ;
            });