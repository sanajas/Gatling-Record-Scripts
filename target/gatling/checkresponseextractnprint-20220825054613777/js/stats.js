var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2",
        "ok": "0",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "191",
        "ok": "-",
        "ko": "191"
    },
    "maxResponseTime": {
        "total": "3394",
        "ok": "-",
        "ko": "3394"
    },
    "meanResponseTime": {
        "total": "1793",
        "ok": "-",
        "ko": "1793"
    },
    "standardDeviation": {
        "total": "1602",
        "ok": "-",
        "ko": "1602"
    },
    "percentiles1": {
        "total": "1793",
        "ok": "-",
        "ko": "1793"
    },
    "percentiles2": {
        "total": "2593",
        "ok": "-",
        "ko": "2593"
    },
    "percentiles3": {
        "total": "3234",
        "ok": "-",
        "ko": "3234"
    },
    "percentiles4": {
        "total": "3362",
        "ok": "-",
        "ko": "3362"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 2,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.5",
        "ok": "-",
        "ko": "0.5"
    }
},
contents: {
"req_get-one-user-da-4ca0c": {
        type: "REQUEST",
        name: "Get one user data ",
path: "Get one user data ",
pathFormatted: "req_get-one-user-da-4ca0c",
stats: {
    "name": "Get one user data ",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "3394",
        "ok": "-",
        "ko": "3394"
    },
    "maxResponseTime": {
        "total": "3394",
        "ok": "-",
        "ko": "3394"
    },
    "meanResponseTime": {
        "total": "3394",
        "ok": "-",
        "ko": "3394"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "3394",
        "ok": "-",
        "ko": "3394"
    },
    "percentiles2": {
        "total": "3394",
        "ok": "-",
        "ko": "3394"
    },
    "percentiles3": {
        "total": "3394",
        "ok": "-",
        "ko": "3394"
    },
    "percentiles4": {
        "total": "3394",
        "ok": "-",
        "ko": "3394"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.25",
        "ok": "-",
        "ko": "0.25"
    }
}
    },"req_get-all-user-da-6babf": {
        type: "REQUEST",
        name: "Get all user data and save one data in some variable ",
path: "Get all user data and save one data in some variable ",
pathFormatted: "req_get-all-user-da-6babf",
stats: {
    "name": "Get all user data and save one data in some variable ",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "191",
        "ok": "-",
        "ko": "191"
    },
    "maxResponseTime": {
        "total": "191",
        "ok": "-",
        "ko": "191"
    },
    "meanResponseTime": {
        "total": "191",
        "ok": "-",
        "ko": "191"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "191",
        "ok": "-",
        "ko": "191"
    },
    "percentiles2": {
        "total": "191",
        "ok": "-",
        "ko": "191"
    },
    "percentiles3": {
        "total": "191",
        "ok": "-",
        "ko": "191"
    },
    "percentiles4": {
        "total": "191",
        "ok": "-",
        "ko": "191"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.25",
        "ok": "-",
        "ko": "0.25"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
