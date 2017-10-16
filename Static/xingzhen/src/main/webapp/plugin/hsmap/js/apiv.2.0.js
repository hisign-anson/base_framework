window.VTC = {
    "ditu": {
        "normal": {
            "version": "088",
            "updateDate": "20151125"
        },
        "satellite": {
            "version": "009",
            "updateDate": "20150601"
        },
        "normalTraffic": {
            "version": "081",
            "updateDate": "20150815"
        },
        "satelliteTraffic": {
            "version": "083",
            "updateDate": "20150815"
        },
        "mapJS": {
            "version": "104",
            "updateDate": "20151125"
        },
        "satelliteStreet": {
            "version": "083",
            "updateDate": "20150815"
        },
        "panoClick": {
            "version": "1033",
            "updateDate": "201400823"
        },
        "panoUdt": {
            "version": "20151126",
            "updateDate": "20151126"
        },
        "panoSwfAPI": {
            "version": "20150123",
            "updateDate": "20150123"
        },
        "panoSwfPlace": {
            "version": "20141112",
            "updateDate": "20141112"
        },
        "earthVector": {
            "version": "001",
            "updateDate": "20150826"
        }
    },
    "webapp": {
        "high_normal": {
            "version": "001",
            "updateDate": "20141209"
        },
        "lower_normal": {
            "version": "002",
            "updateDate": "20150529"
        }
    },
    "api_for_mobile": {
        "vector": {
            "version": "002",
            "updateDate": "20150529"
        },
        "vectorIcon": {
            "version": "002",
            "updateDate": "20150529"
        }
    }
};
window.BMAP_AUTHENTIC_KEY = "O69mIPtSwrCNzUg7olEDsrvd";
//window.BMAP_AUTHENTIC_KEY = null;
(function() {
    function aa(a) {
        throw a;
    }
    var j = void 0,
        o = !0,
        p = null,
        q = !1;

    function s() {
        return function() {}
    }

    function ba(a) {
        return function(b) {
            this[a] = b
        }
    }

    function t(a) {
        return function() {
            return this[a]
        }
    }

    function ca(a) {
        return function() {
            return a
        }
    }
    var da, ga = [];

    function ha(a) {
        return function() {
            return ga[a].apply(this, arguments)
        }
    }

    function ia(a, b) {
        return ga[a] = b
    }
    var ja, x = ja = x || {
        version: "1.3.4"
    };
    x.ca = "$BAIDU$";
    window[x.ca] = window[x.ca] || {};
    x.object = x.object || {};
    x.extend = x.object.extend = function(a, b) {
        for (var c in b) b.hasOwnProperty(c) && (a[c] = b[c]);
        return a
    };
    x.D = x.D || {};
    x.D.$ = function(a) {
        return "string" == typeof a || a instanceof String ? document.getElementById(a) : a && a.nodeName && (1 == a.nodeType || 9 == a.nodeType) ? a : p
    };
    x.$ = x.Cc = x.D.$;
    x.D.U = function(a) {
        a = x.D.$(a);
        if (a === p) return a;
        a.style.display = "none";
        return a
    };
    x.U = x.D.U;
    x.lang = x.lang || {};
    x.lang.ug = function(a) {
        return "[object String]" == Object.prototype.toString.call(a)
    };
    x.ug = x.lang.ug;
    x.D.Qj = function(a) {
        return x.lang.ug(a) ? document.getElementById(a) : a
    };
    x.Qj = x.D.Qj;
    x.D.getElementsByClassName = function(a, b) {
        var c;
        if (a.getElementsByClassName) c = a.getElementsByClassName(b);
        else {
            var d = a;
            d == p && (d = document);
            c = [];
            var d = d.getElementsByTagName("*"),
                e = d.length,
                f = RegExp("(^|\\s)" + b + "(\\s|$)"),
                g, i;
            for (i = g = 0; g < e; g++) f.test(d[g].className) && (c[i] = d[g], i++)
        }
        return c
    };
    x.getElementsByClassName = x.D.getElementsByClassName;
    x.D.contains = function(a, b) {
        var c = x.D.Qj,
            a = c(a),
            b = c(b);
        return a.contains ? a != b && a.contains(b) : !!(a.compareDocumentPosition(b) & 16)
    };
    x.ea = x.ea || {};
    /msie (\d+\.\d)/i.test(navigator.userAgent) && (x.ea.la = x.la = document.documentMode || +RegExp.$1);
    var ka = {
        cellpadding: "cellPadding",
        cellspacing: "cellSpacing",
        colspan: "colSpan",
        rowspan: "rowSpan",
        valign: "vAlign",
        usemap: "useMap",
        frameborder: "frameBorder"
    };
    8 > x.ea.la ? (ka["for"] = "htmlFor", ka["class"] = "className") : (ka.htmlFor = "for", ka.className = "class");
    x.D.sG = ka;
    x.D.iF = function(a, b, c) {
        a = x.D.$(a);
        if (a === p) return a;
        if ("style" == b) a.style.cssText = c;
        else {
            b = x.D.sG[b] || b;
            a.setAttribute(b, c)
        }
        return a
    };
    x.iF = x.D.iF;
    x.D.jF = function(a, b) {
        a = x.D.$(a);
        if (a === p) return a;
        for (var c in b) x.D.iF(a, c, b[c]);
        return a
    };
    x.jF = x.D.jF;
    x.Ok = x.Ok || {};
    (function() {
        var a = RegExp("(^[\\s\\t\\xa0\\u3000]+)|([\\u3000\\xa0\\s\\t]+$)", "g");
        x.Ok.trim = function(b) {
            return ("" + b).replace(a, "")
        }
    })();
    x.trim = x.Ok.trim;
    x.Ok.Oo = function(a, b) {
        var a = "" + a,
            c = Array.prototype.slice.call(arguments, 1),
            d = Object.prototype.toString;
        if (c.length) {
            c = c.length == 1 ? b !== p && /\[object Array\]|\[object Object\]/.test(d.call(b)) ? b : c : c;
            return a.replace(/#\{(.+?)\}/g, function(a, b) {
                var g = c[b];
                "[object Function]" == d.call(g) && (g = g(b));
                return "undefined" == typeof g ? "" : g
            })
        }
        return a
    };
    x.Oo = x.Ok.Oo;
    x.D.Rb = function(a, b) {
        a = x.D.$(a);
        if (a === p) return a;
        for (var c = a.className.split(/\s+/), d = b.split(/\s+/), e, f = d.length, g, i = 0; i < f; ++i) {
            g = 0;
            for (e = c.length; g < e; ++g)
                if (c[g] == d[i]) {
                    c.splice(g, 1);
                    break
                }
        }
        a.className = c.join(" ");
        return a
    };
    x.Rb = x.D.Rb;
    x.D.Gx = function(a, b, c) {
        a = x.D.$(a);
        if (a === p) return a;
        var d;
        if (a.insertAdjacentHTML) a.insertAdjacentHTML(b, c);
        else {
            d = a.ownerDocument.createRange();
            b = b.toUpperCase();
            if (b == "AFTERBEGIN" || b == "BEFOREEND") {
                d.selectNodeContents(a);
                d.collapse(b == "AFTERBEGIN")
            } else {
                b = b == "BEFOREBEGIN";
                d[b ? "setStartBefore" : "setEndAfter"](a);
                d.collapse(b)
            }
            d.insertNode(d.createContextualFragment(c))
        }
        return a
    };
    x.Gx = x.D.Gx;
    x.D.show = function(a) {
        a = x.D.$(a);
        if (a === p) return a;
        a.style.display = "";
        return a
    };
    x.show = x.D.show;
    x.D.CD = function(a) {
        a = x.D.$(a);
        return a === p ? a : a.nodeType == 9 ? a : a.ownerDocument || a.document
    };
    x.D.Ta = function(a, b) {
        a = x.D.$(a);
        if (a === p) return a;
        for (var c = b.split(/\s+/), d = a.className, e = " " + d + " ", f = 0, g = c.length; f < g; f++) e.indexOf(" " + c[f] + " ") < 0 && (d = d + (" " + c[f]));
        a.className = d;
        return a
    };
    x.Ta = x.D.Ta;
    x.D.BB = x.D.BB || {};
    x.D.Gl = x.D.Gl || [];
    x.D.Gl.filter = function(a, b, c) {
        for (var d = 0, e = x.D.Gl, f; f = e[d]; d++)
            if (f = f[c]) b = f(a, b);
        return b
    };
    x.Ok.cO = function(a) {
        return a.indexOf("-") < 0 && a.indexOf("_") < 0 ? a : a.replace(/[-_][^-_]/g, function(a) {
            return a.charAt(1).toUpperCase()
        })
    };
    x.D.p_ = function(a) {
        x.D.$s(a, "expand") ? x.D.Rb(a, "expand") : x.D.Ta(a, "expand")
    };
    x.D.$s = function(a) {
        if (arguments.length <= 0 || typeof a === "function") return this;
        if (this.size() <= 0) return q;
        var a = a.replace(/^\s+/g, "").replace(/\s+$/g, "").replace(/\s+/g, " "),
            b = a.split(" "),
            c;
        x.forEach(this, function(a) {
            for (var a = a.className, e = 0; e < b.length; e++)
                if (!~(" " + a + " ").indexOf(" " + b[e] + " ")) {
                    c = q;
                    return
                }
            c !== q && (c = o)
        });
        return c
    };
    x.D.tj = function(a, b) {
        var c = x.D,
            a = c.$(a);
        if (a === p) return a;
        var b = x.Ok.cO(b),
            d = a.style[b];
        if (!d) var e = c.BB[b],
            d = a.currentStyle || (x.ea.la ? a.style : getComputedStyle(a, p)),
            d = e && e.get ? e.get(a, d) : d[e || b];
        if (e = c.Gl) d = e.filter(b, d, "get");
        return d
    };
    x.tj = x.D.tj;
    /opera\/(\d+\.\d)/i.test(navigator.userAgent) && (x.ea.opera = +RegExp.$1);
    x.ea.YL = /webkit/i.test(navigator.userAgent);
    x.ea.XX = /gecko/i.test(navigator.userAgent) && !/like gecko/i.test(navigator.userAgent);
    x.ea.oE = "CSS1Compat" == document.compatMode;
    x.D.ha = function(a) {
        a = x.D.$(a);
        if (a === p) return a;
        var b = x.D.CD(a),
            c = x.ea,
            d = x.D.tj;
        c.XX > 0 && b.getBoxObjectFor && d(a, "position");
        var e = {
                left: 0,
                top: 0
            },
            f;
        if (a == (c.la && !c.oE ? b.body : b.documentElement)) return e;
        if (a.getBoundingClientRect) {
            a = a.getBoundingClientRect();
            e.left = Math.floor(a.left) + Math.max(b.documentElement.scrollLeft, b.body.scrollLeft);
            e.top = Math.floor(a.top) + Math.max(b.documentElement.scrollTop, b.body.scrollTop);
            e.left = e.left - b.documentElement.clientLeft;
            e.top = e.top - b.documentElement.clientTop;
            a = b.body;
            b = parseInt(d(a, "borderLeftWidth"));
            d = parseInt(d(a, "borderTopWidth"));
            if (c.la && !c.oE) {
                e.left = e.left - (isNaN(b) ? 2 : b);
                e.top = e.top - (isNaN(d) ? 2 : d)
            }
        } else {
            f = a;
            do {
                e.left = e.left + f.offsetLeft;
                e.top = e.top + f.offsetTop;
                if (c.YL > 0 && d(f, "position") == "fixed") {
                    e.left = e.left + b.body.scrollLeft;
                    e.top = e.top + b.body.scrollTop;
                    break
                }
                f = f.offsetParent
            } while (f && f != a);
            if (c.opera > 0 || c.YL > 0 && d(a, "position") == "absolute") e.top = e.top - b.body.offsetTop;
            for (f = a.offsetParent; f && f != b.body;) {
                e.left = e.left - f.scrollLeft;
                if (!c.opera || f.tagName != "TR") e.top = e.top - f.scrollTop;
                f = f.offsetParent
            }
        }
        return e
    };
    /firefox\/(\d+\.\d)/i.test(navigator.userAgent) && (x.ea.rg = +RegExp.$1);
    /BIDUBrowser/i.test(navigator.userAgent) && (x.ea.Y0 = o);
    var la = navigator.userAgent;
    /(\d+\.\d)?(?:\.\d)?\s+safari\/?(\d+\.\d+)?/i.test(la) && !/chrome/i.test(la) && (x.ea.vN = +(RegExp.$1 || RegExp.$2));
    /chrome\/(\d+\.\d)/i.test(navigator.userAgent) && (x.ea.UJ = +RegExp.$1);
    x.jc = x.jc || {};
    x.jc.Db = function(a, b) {
        var c, d, e = a.length;
        if ("function" == typeof b)
            for (d = 0; d < e; d++) {
                c = a[d];
                c = b.call(a, c, d);
                if (c === q) break
            }
        return a
    };
    x.Db = x.jc.Db;
    x.lang.ca = function() {
        return "TANGRAM__" + (window[x.ca]._counter++).toString(36)
    };
    window[x.ca]._counter = window[x.ca]._counter || 1;
    window[x.ca]._instances = window[x.ca]._instances || {};
    x.lang.it = function(a) {
        return "[object Function]" == Object.prototype.toString.call(a)
    };
    x.lang.Ba = function(a) {
        this.ca = a || x.lang.ca();
        window[x.ca]._instances[this.ca] = this
    };
    window[x.ca]._instances = window[x.ca]._instances || {};
    x.lang.Ba.prototype.ei = ha(0);
    x.lang.Ba.prototype.toString = function() {
        return "[object " + (this.hQ || "Object") + "]"
    };
    x.lang.Yy = function(a, b) {
        this.type = a;
        this.returnValue = o;
        this.target = b || p;
        this.currentTarget = p
    };
    x.lang.Ba.prototype.addEventListener = function(a, b, c) {
        if (x.lang.it(b)) {
            !b.Xk && (b.Xk = {});
            !this.Hi && (this.Hi = {});
            var d = this.Hi,
                e;
            if (typeof c == "string" && c) {
                /[^\w\-]/.test(c) && aa("nonstandard key:" + c);
                e = b.zx = c
            }
            a.indexOf("on") != 0 && (a = "on" + a);
            typeof d[a] != "object" && (d[a] = {});
            typeof b.Xk[a] != "object" && (b.Xk[a] = {});
            e = e || x.lang.ca();
            b.Xk[a].zx = e;
            d[a][e] = b
        }
    };
    x.lang.Ba.prototype.removeEventListener = function(a, b) {
        a.indexOf("on") != 0 && (a = "on" + a);
        if (x.lang.it(b)) {
            if (!b.Xk || !b.Xk[a]) return;
            b = b.Xk[a].zx
        } else if (!x.lang.ug(b)) return;
        !this.Hi && (this.Hi = {});
        var c = this.Hi;
        c[a] && c[a][b] && delete c[a][b]
    };
    x.lang.Ba.prototype.dispatchEvent = function(a, b) {
        x.lang.ug(a) && (a = new x.lang.Yy(a));
        !this.Hi && (this.Hi = {});
        var b = b || {},
            c;
        for (c in b) a[c] = b[c];
        var d = this.Hi,
            e = a.type;
        a.target = a.target || this;
        a.currentTarget = this;
        e.indexOf("on") != 0 && (e = "on" + e);
        x.lang.it(this[e]) && this[e].apply(this, arguments);
        if (typeof d[e] == "object")
            for (c in d[e]) d[e][c].apply(this, arguments);
        return a.returnValue
    };
    x.lang.sa = function(a, b, c) {
        var d, e, f = a.prototype;
        e = new Function;
        e.prototype = b.prototype;
        e = a.prototype = new e;
        for (d in f) e[d] = f[d];
        a.prototype.constructor = a;
        a.g_ = b.prototype;
        if ("string" == typeof c) e.hQ = c
    };
    x.sa = x.lang.sa;
    x.lang.Mc = function(a) {
        return window[x.ca]._instances[a] || p
    };
    x.platform = x.platform || {};
    x.platform.RL = /macintosh/i.test(navigator.userAgent);
    x.platform.J2 = /MicroMessenger/i.test(navigator.userAgent);
    x.platform.ZL = /windows/i.test(navigator.userAgent);
    x.platform.eY = /x11/i.test(navigator.userAgent);
    x.platform.Cm = /android/i.test(navigator.userAgent);
    /android (\d+\.\d)/i.test(navigator.userAgent) && (x.platform.CJ = x.CJ = RegExp.$1);
    x.platform.ZX = /ipad/i.test(navigator.userAgent);
    x.platform.kE = /iphone/i.test(navigator.userAgent);

    function ma(a, b) {
        a.domEvent = b = window.event || b;
        a.clientX = b.clientX || b.pageX;
        a.clientY = b.clientY || b.pageY;
        a.offsetX = b.offsetX || b.layerX;
        a.offsetY = b.offsetY || b.layerY;
        a.screenX = b.screenX;
        a.screenY = b.screenY;
        a.ctrlKey = b.ctrlKey || b.metaKey;
        a.shiftKey = b.shiftKey;
        a.altKey = b.altKey;
        if (b.touches) {
            a.touches = [];
            for (var c = 0; c < b.touches.length; c++) a.touches.push({
                clientX: b.touches[c].clientX,
                clientY: b.touches[c].clientY,
                screenX: b.touches[c].screenX,
                screenY: b.touches[c].screenY,
                pageX: b.touches[c].pageX,
                pageY: b.touches[c].pageY,
                target: b.touches[c].target,
                identifier: b.touches[c].identifier
            })
        }
        if (b.changedTouches) {
            a.changedTouches = [];
            for (c = 0; c < b.changedTouches.length; c++) a.changedTouches.push({
                clientX: b.changedTouches[c].clientX,
                clientY: b.changedTouches[c].clientY,
                screenX: b.changedTouches[c].screenX,
                screenY: b.changedTouches[c].screenY,
                pageX: b.changedTouches[c].pageX,
                pageY: b.changedTouches[c].pageY,
                target: b.changedTouches[c].target,
                identifier: b.changedTouches[c].identifier
            })
        }
        if (b.targetTouches) {
            a.targetTouches = [];
            for (c = 0; c < b.targetTouches.length; c++) a.targetTouches.push({
                clientX: b.targetTouches[c].clientX,
                clientY: b.targetTouches[c].clientY,
                screenX: b.targetTouches[c].screenX,
                screenY: b.targetTouches[c].screenY,
                pageX: b.targetTouches[c].pageX,
                pageY: b.targetTouches[c].pageY,
                target: b.targetTouches[c].target,
                identifier: b.targetTouches[c].identifier
            })
        }
        a.rotation = b.rotation;
        a.scale = b.scale;
        return a
    }
    x.lang.Pw = function(a) {
        var b = window[x.ca];
        b.sS && delete b.sS[a]
    };
    x.event = {};
    x.K = x.event.K = function(a, b, c) {
        if (!(a = x.$(a))) return a;
        b = b.replace(/^on/, "");
        a.addEventListener ? a.addEventListener(b, c, q) : a.attachEvent && a.attachEvent("on" + b, c);
        return a
    };
    x.bd = x.event.bd = function(a, b, c) {
        if (!(a = x.$(a))) return a;
        b = b.replace(/^on/, "");
        a.removeEventListener ? a.removeEventListener(b, c, q) : a.detachEvent && a.detachEvent("on" + b, c);
        return a
    };
    x.D.$s = function(a, b) {
        if (!a || !a.className || typeof a.className != "string") return q;
        var c = -1;
        try {
            c = a.className == b || a.className.search(RegExp("(\\s|^)" + b + "(\\s|$)"))
        } catch (d) {
            return q
        }
        return c > -1
    };
    x.GK = function() {
        function a(a) {
            document.addEventListener && (this.element = a, this.JK = this.xk ? "touchstart" : "mousedown", this.lD = this.xk ? "touchmove" : "mousemove", this.kD = this.xk ? "touchend" : "mouseup", this.qh = q, this.bu = this.au = 0, this.element.addEventListener(this.JK, this, q), ja.K(this.element, "mousedown", s()), this.handleEvent(p))
        }
        a.prototype = {
            xk: "ontouchstart" in window || "createTouch" in document,
            start: function(a) {
                na(a);
                this.qh = q;
                this.au = this.xk ? a.touches[0].clientX : a.clientX;
                this.bu = this.xk ? a.touches[0].clientY : a.clientY;
                this.element.addEventListener(this.lD, this, q);
                this.element.addEventListener(this.kD, this, q)
            },
            move: function(a) {
                oa(a);
                var c = this.xk ? a.touches[0].clientY : a.clientY;
                if (10 < Math.abs((this.xk ? a.touches[0].clientX : a.clientX) - this.au) || 10 < Math.abs(c - this.bu)) this.qh = o
            },
            end: function(a) {
                oa(a);
                this.qh || (a = document.createEvent("Event"), a.initEvent("tap", q, o), this.element.dispatchEvent(a));
                this.element.removeEventListener(this.lD, this, q);
                this.element.removeEventListener(this.kD, this, q)
            },
            handleEvent: function(a) {
                if (a) switch (a.type) {
                    case this.JK:
                        this.start(a);
                        break;
                    case this.lD:
                        this.move(a);
                        break;
                    case this.kD:
                        this.end(a)
                }
            }
        };
        return function(b) {
            return new a(b)
        }
    }();
    var z = window.BMap || {};
    z.version = "2.0";
    z.mJ = 0.34 > Math.random();
    0 <= z.version.indexOf("#") && (z.version = "2.0");
    z.yr = [];
    z.Te = function(a) {
        this.yr.push(a)
    };
    z.or = [];
    z.Pm = function(a) {
        this.or.push(a)
    };
    z.GU = z.apiLoad || s();
    var pa = window.BMAP_AUTHENTIC_KEY;
    window.BMAP_AUTHENTIC_KEY = p;
    var qa = window.BMap_loadScriptTime,
        ra = (new Date).getTime(),
        sa = p,
        ua = o,
        va = p,
        wa = 5042,
        xa = 5002,
        ya = 5003,
        za = "load_mapclick",
        Aa = 5038,
        Ba = 5041,
        Ca = 5047,
        Da = 5036,
        Fa = 5039,
        Ga = 5037,
        Ha = 5040,
        Ia = 5011,
        Ja = 7E3;

    function Ka(a, b) {
        if (a = x.$(a)) {
            var c = this;
            x.lang.Ba.call(c);
            b = b || {};
            c.M = {
                hC: 200,
                bc: o,
                Xw: q,
                dD: o,
                Lo: o,
                Mo: o,
                EK: o,
                fD: o,
                Es: o,
                Vw: o,
                hm: o,
                Jo: b.enable3DBuilding || q,
                Gc: 25,
                Z_: 240,
                uU: 450,
                Wb: F.Wb,
                Cd: F.Cd,
                Jx: !!b.Jx,
                dc: Math.round(b.minZoom) || 1,
                Yb: Math.round(b.maxZoom) || 19,
                Hb: b.mapType || La,
                A3: q,
                Ww: o,
                Tw: 500,
                eW: b.enableHighResolution !== q,
                nj: b.enableMapClick !== q,
                devicePixelRatio: b.devicePixelRatio || window.devicePixelRatio || 1,
                JF: b.vectorMapLevel || (G() ? 3 : 99),
                te: b.mapStyle || p,
                oY: b.logoControl === q ? q : o,
                OU: [],
                ww: b.beforeClickIcon || p
            };
            c.M.te && (this.OX(c.M.te.controls), this.LL(c.M.te.geotableId));
            c.M.te && c.M.te.styleId && c.t2(c.M.te.styleId);
            c.M.$l = {
                dark: {
                    backColor: "#2D2D2D",
                    textColor: "#bfbfbf",
                    iconUrl: "dicons"
                },
                normal: {
                    backColor: "#F3F1EC",
                    textColor: "#c61b1b",
                    iconUrl: "icons"
                },
                light: {
                    backColor: "#EBF8FC",
                    textColor: "#017fb4",
                    iconUrl: "licons"
                }
            };
            b.enableAutoResize && (c.M.Vw = b.enableAutoResize);
            b.enableStreetEntrance === q && (c.M.hm = b.enableStreetEntrance);
            b.enableDeepZoom === q && (c.M.EK = b.enableDeepZoom);
            var d = c.M.OU;
            if (G())
                for (var e = 0, f = d.length; e < f; e++)
                    if (x.ea[d[e]]) {
                        c.M.devicePixelRatio = 1;
                        break
                    }
            d = -1 < navigator.userAgent.toLowerCase().indexOf("android");
            e = -1 < navigator.userAgent.toLowerCase().indexOf("mqqbrowser");
            if (-1 < navigator.userAgent.toLowerCase().indexOf("UCBrowser") || d && e) c.M.JF = 99;
            c.Ua = a;
            c.uB(a);
            a.unselectable = "on";
            a.innerHTML = "";
            a.appendChild(c.ta());
            b.size && this.Jd(b.size);
            d = c.wb();
            c.width = d.width;
            c.height = d.height;
            c.offsetX = 0;
            c.offsetY = 0;
            c.platform = a.firstChild;
            c.ue = c.platform.firstChild;
            c.ue.style.width = c.width + "px";
            c.ue.style.height = c.height + "px";
            c.Td = {};
            c.ef = new H(0, 0);
            c.wc = new H(0, 0);
            c.Ga = 3;
            c.Hc = 0;
            c.zC = p;
            c.yC = p;
            c.Vb = "";
            c.Bw = "";
            c.Nh = {};
            c.Nh.custom = {};
            c.Sa = 0;
            c.P = new Ma(a, {
                Of: "api",
                xS: o
            });
            c.P.U();
            c.P.lF(c);
            b = b || {};
            d = c.Hb = c.M.Hb;
            c.we = d.Zo();
            d === Na && Oa(xa);
            d === Pa && Oa(ya);
            d = c.M;
            d.wO = Math.round(b.minZoom);
            d.vO = Math.round(b.maxZoom);
            c.Su();
            c.R = {
                Ic: q,
                kc: 0,
                mt: 0,
                cM: 0,
                N2: 0,
                $B: q,
                WE: -1,
                Oe: []
            };
            c.platform.style.cursor = c.M.Wb;
            for (e = 0; e < z.yr.length; e++) z.yr[e](c);
            c.R.WE = e;
            c.ba();
            I.load("map", function() {
                c.vb()
            });
            c.M.nj && (setTimeout(function() {
                Oa(za)
            }, 1E3), I.load("mapclick", function() {
                window.MPC_Mgr = window.MPC_Mgr || {};
                window.MPC_Mgr[c.ca] = new Ra(c)
            }, o));
            Sa() && I.load("oppc", function() {
                c.oz()
            });
            G() && I.load("opmb", function() {
                c.oz()
            });
            a = p;
            c.JB = []
        }
    }
    x.lang.sa(Ka, x.lang.Ba, "Map");
    x.extend(Ka.prototype, {
        ta: function() {
            var a = K("div"),
                b = a.style;
            b.overflow = "visible";
            b.position = "absolute";
            b.zIndex = "0";
            b.top = b.left = "0px";
            var b = K("div", {
                    "class": "BMap_mask"
                }),
                c = b.style;
            c.position = "absolute";
            c.top = c.left = "0px";
            c.zIndex = "9";
            c.overflow = "hidden";
            c.WebkitUserSelect = "none";
            a.appendChild(b);
            return a
        },
        uB: function(a) {
            var b = a.style;
            b.overflow = "hidden";
            "absolute" !== Ta(a).position && (b.position = "relative", b.zIndex = 0);
            b.backgroundColor = "#F3F1EC";
            b.color = "#000";
            b.textAlign = "left"
        },
        ba: function() {
            var a = this;
            a.Ur = function() {
                var b = a.wb();
                if (a.width !== b.width || a.height !== b.height) {
                    var c = new L(a.width, a.height),
                        d = new N("onbeforeresize");
                    d.size = c;
                    a.dispatchEvent(d);
                    a.gk((b.width - a.width) / 2, (b.height - a.height) / 2);
                    a.ue.style.width = (a.width = b.width) + "px";
                    a.ue.style.height = (a.height = b.height) + "px";
                    c = new N("onresize");
                    c.size = b;
                    a.dispatchEvent(c)
                }
            };
            a.M.Vw && (a.R.Yr = setInterval(a.Ur, 80))
        },
        gk: function(a, b, c, d) {
            var e = this.va().Lc(this.fa()),
                f = this.we,
                g = o;
            c && H.QL(c) && (this.ef = new H(c.lng, c.lat), g = q);
            if (c = c && d ? f.Gm(c, this.Vb) : this.wc)
                if (this.wc = new H(c.lng + a * e, c.lat - b * e), (a = f.ph(this.wc, this.Vb)) && g) this.ef = a
        },
        Fg: function(a, b) {
            if (Ua(a) && (this.Su(), this.dispatchEvent(new N("onzoomstart")), a = this.Sn(a).zoom, a !== this.Ga)) {
                this.Hc = this.Ga;
                this.Ga = a;
                var c;
                b ? c = b : this.ih() && (c = this.ih().ha());
                c && (c = this.fc(c, this.Hc), this.gk(this.width / 2 - c.x, this.height / 2 - c.y, this.zb(c, this.Hc), o));
                this.dispatchEvent(new N("onzoomstartcode"))
            }
        },
        Nc: function(a) {
            this.Fg(a)
        },
        NF: function(a) {
            this.Fg(this.Ga + 1, a)
        },
        OF: function(a) {
            this.Fg(this.Ga - 1, a)
        },
        ti: function(a) {
            a instanceof H && (this.wc = this.we.Gm(a, this.Vb), this.ef = H.QL(a) ? new H(a.lng, a.lat) : this.we.ph(this.wc, this.Vb))
        },
        yg: function(a, b) {
            a = Math.round(a) || 0;
            b = Math.round(b) || 0;
            this.gk(-a, -b)
        },
        lw: function(a) {
            a && Va(a.Ce) && (a.Ce(this), this.dispatchEvent(new N("onaddcontrol", a)))
        },
        jN: function(a) {
            a && Va(a.remove) && (a.remove(), this.dispatchEvent(new N("onremovecontrol", a)))
        },
        ro: function(a) {
            a && Va(a.pa) && (a.pa(this), this.dispatchEvent(new N("onaddcontextmenu", a)))
        },
        vp: function(a) {
            a && Va(a.remove) && (this.dispatchEvent(new N("onremovecontextmenu", a)), a.remove())
        },
        Ia: function(a) {
            a && Va(a.Ce) && (a.Ce(this), this.dispatchEvent(new N("onaddoverlay", a)))
        },
        Sb: function(a) {
            a && Va(a.remove) && (a.remove(), this.dispatchEvent(new N("onremoveoverlay", a)))
        },
        XJ: function() {
            this.dispatchEvent(new N("onclearoverlays"))
        },
        Yg: function(a) {
            a && this.dispatchEvent(new N("onaddtilelayer", a))
        },
        yh: function(a) {
            a && this.dispatchEvent(new N("onremovetilelayer", a))
        },
        Bg: function(a) {
            if (this.Hb !== a) {
                var b = new N("onsetmaptype");
                b.p3 = this.Hb;
                this.Hb = this.M.Hb = a;
                this.we = this.Hb.Zo();
                this.gk(0, 0, this.Ka(), o);
                this.Su();
                var c = this.Sn(this.fa()).zoom;
                this.Fg(c);
                this.dispatchEvent(b);
                b = new N("onmaptypechange");
                b.Ga = c;
                b.Hb = a;
                this.dispatchEvent(b);
                (a === Wa || a === Pa) && Oa(ya)
            }
        },
        Vf: function(a) {
            var b = this;
            if (a instanceof H) b.ti(a, {
                noAnimation: o
            });
            else if (Xa(a))
                if (b.Hb === Na) {
                    var c = F.dC[a];
                    c && (pt = c.m, b.Vf(pt))
                } else {
                    var d = this.xH();
                    d.oF(function(c) {
                        0 === d.qm() && 2 === d.Da.result.type && (b.Vf(c.vk(0).point), Na.rk(a) && b.kF(a))
                    });
                    d.search(a, {
                        log: "center"
                    })
                }
        },
        Yd: function(a, b) {
            "[object Undefined]" !== Object.prototype.toString.call(b) && (b = parseInt(b));
            va = G() ? Za.Ei.mk(z.mJ ? 102 : 101) : Za.Ei.mk(1);
            va.cu();
            va.jz = +new Date;
            va.oc("script_loaded", ra - qa);
            va.oc("centerAndZoom");
            z.Ij("cus.fire", "time", {
                z_loadscripttime: ra - qa
            });
            var c = this;
            if (Xa(a))
                if (c.Hb === Na) {
                    var d = F.dC[a];
                    d && (pt = d.m, c.Yd(pt, b))
                } else {
                    var e = c.xH();
                    e.oF(function(d) {
                        if (0 === e.qm() && (2 === e.Da.result.type || 11 === e.Da.result.type)) {
                            var d = d.vk(0).point,
                                f = b || P.$w(e.Da.content.level, c);
                            c.Yd(d, f);
                            Na.rk(a) && c.kF(a)
                        }
                    });
                    e.search(a, {
                        log: "center"
                    })
                } else if (a instanceof H && b) {
                b = c.Sn(b).zoom;
                c.Hc = c.Ga || b;
                c.Ga = b;
                d = c.ef;
                c.ef = new H(a.lng, a.lat);
                c.wc = c.we.Gm(c.ef, c.Vb);
                c.zC = c.zC || c.Ga;
                c.yC = c.yC || c.ef;
                var f = new N("onload"),
                    g = new N("onloadcode");
                f.point = new H(a.lng, a.lat);
                f.pixel = c.fc(c.ef, c.Ga);
                f.zoom = b;
                c.loaded || (c.loaded = o, c.dispatchEvent(f), sa || (sa = $a()));
                c.dispatchEvent(g);
                f = new N("onmoveend");
                f.$G = "centerAndZoom";
                d.lb(c.ef) || c.dispatchEvent(f);
                c.dispatchEvent(new N("onmoveend"));
                c.Hc !== c.Ga && (d = new N("onzoomend"), d.$G = "centerAndZoom", c.dispatchEvent(d));
                c.M.Jo && c.Jo()
            }
        },
        xH: function() {
            this.R.jM || (this.R.jM = new ab(1));
            return this.R.jM
        },
        reset: function() {
            this.Yd(this.yC, this.zC, o)
        },
        enableDragging: function() {
            this.M.bc = o
        },
        disableDragging: function() {
            this.M.bc = q
        },
        enableInertialDragging: function() {
            this.M.Ww = o
        },
        disableInertialDragging: function() {
            this.M.Ww = q
        },
        enableScrollWheelZoom: function() {
            this.M.Mo = o
        },
        disableScrollWheelZoom: function() {
            this.M.Mo = q
        },
        enableContinuousZoom: function() {
            this.M.Lo = o
        },
        disableContinuousZoom: function() {
            this.M.Lo = q
        },
        enableDoubleClickZoom: function() {
            this.M.dD = o
        },
        disableDoubleClickZoom: function() {
            this.M.dD = q
        },
        enableKeyboard: function() {
            this.M.Xw = o
        },
        disableKeyboard: function() {
            this.M.Xw = q
        },
        enablePinchToZoom: function() {
            this.M.Es = o
        },
        disablePinchToZoom: function() {
            this.M.Es = q
        },
        enableAutoResize: function() {
            this.M.Vw = o;
            this.Ur();
            this.R.Yr || (this.R.Yr = setInterval(this.Ur, 80))
        },
        disableAutoResize: function() {
            this.M.Vw = q;
            this.R.Yr && (clearInterval(this.R.Yr), this.R.Yr = p)
        },
        Jo: function() {
            this.M.Jo = o;
            this.Hn || (this.Hn = new bb({
                NK: o
            }), this.Yg(this.Hn))
        },
        PV: function() {
            this.M.Jo = q;
            this.Hn && (this.yh(this.Hn), this.Hn = p, delete this.Hn)
        },
        wb: function() {
            return this.ls && this.ls instanceof L ? new L(this.ls.width, this.ls.height) : new L(this.Ua.clientWidth, this.Ua.clientHeight)
        },
        Jd: function(a) {
            a && a instanceof L ? (this.ls = a, this.Ua.style.width = a.width + "px", this.Ua.style.height = a.height + "px") : this.ls = p
        },
        Ka: t("ef"),
        fa: t("Ga"),
        fV: function() {
            this.Ur()
        },
        Sn: function(a) {
            var b = this.M.dc,
                c = this.M.Yb,
                d = q,
                a = Math.round(a);
            a < b && (d = o, a = b);
            a > c && (d = o, a = c);
            return {
                zoom: a,
                mD: d
            }
        },
        Na: t("Ua"),
        fc: function(a, b) {
            b = b || this.fa();
            return this.we.fc(a, b, this.wc, this.wb(), this.Vb)
        },
        zb: function(a, b) {
            b = b || this.fa();
            return this.we.zb(a, b, this.wc, this.wb(), this.Vb)
        },
        Se: function(a, b) {
            if (a) {
                var c = this.fc(new H(a.lng, a.lat), b);
                c.x -= this.offsetX;
                c.y -= this.offsetY;
                return c
            }
        },
        ZM: function(a, b) {
            if (a) {
                var c = new Q(a.x, a.y);
                c.x += this.offsetX;
                c.y += this.offsetY;
                return this.zb(c, b)
            }
        },
        pointToPixelFor3D: function(a, b) {
            var c = map.Vb;
            this.Hb === Na && c && db.cK(a, this, b)
        },
        k3: function(a, b) {
            var c = map.Vb;
            this.Hb === Na && c && db.bK(a, this, b)
        },
        l3: function(a, b) {
            var c = this,
                d = map.Vb;
            c.Hb === Na && d && db.cK(a, c, function(a) {
                a.x -= c.offsetX;
                a.y -= c.offsetY;
                b && b(a)
            })
        },
        j3: function(a, b) {
            var c = map.Vb;
            this.Hb === Na && c && (a.x += this.offsetX, a.y += this.offsetY, db.bK(a, this, b))
        },
        Ed: function(a) {
            if (!this.Ix()) return new eb;
            var b = a || {},
                a = b.margins || [0, 0, 0, 0],
                c = b.zoom || p,
                b = this.zb({
                    x: a[3],
                    y: this.height - a[2]
                }, c),
                a = this.zb({
                    x: this.width - a[1],
                    y: a[0]
                }, c);
            return new eb(b, a)
        },
        Ix: function() {
            return !!this.loaded
        },
        zR: function(a, b) {
            for (var c = this.va(), d = b.margins || [10, 10, 10, 10], e = b.zoomFactor || 0, f = d[1] + d[3], d = d[0] + d[2], g = c.Uo(), i = c = c.mm(); i >= g; i--) {
                var k = this.va().Lc(i);
                if (a.CF().lng / k < this.width - f && a.CF().lat / k < this.height - d) break
            }
            i += e;
            i < g && (i = g);
            i > c && (i = c);
            return i
        },
        Zs: function(a, b) {
            var c = {
                center: this.Ka(),
                zoom: this.fa()
            };
            if (!a || !a instanceof eb && 0 === a.length || a instanceof eb && a.yj()) return c;
            var d = [];
            a instanceof eb ? (d.push(a.kf()), d.push(a.re())) : d = a.slice(0);
            for (var b = b || {}, e = [], f = 0, g = d.length; f < g; f++) e.push(this.we.Gm(d[f], this.Vb));
            d = new eb;
            for (f = e.length - 1; 0 <= f; f--) d.extend(e[f]);
            if (d.yj()) return c;
            c = d.Ka();
            e = this.zR(d, b);
            b.margins && (d = b.margins, f = (d[1] - d[3]) / 2, d = (d[0] - d[2]) / 2, g = this.va().Lc(e), b.offset && (f = b.offset.width, d = b.offset.height), c.lng += g * f, c.lat += g * d);
            c = this.we.ph(c, this.Vb);
            return {
                center: c,
                zoom: e
            }
        },
        Ah: function(a, b) {
            var c;
            c = a && a.center ? a : this.Zs(a, b);
            var b = b || {},
                d = b.delay || 200;
            if (c.zoom === this.Ga && b.enableAnimation !== q) {
                var e = this;
                setTimeout(function() {
                    e.ti(c.center, {
                        duration: 210
                    })
                }, d)
            } else this.Yd(c.center, c.zoom)
        },
        Qf: t("Td"),
        ih: function() {
            return this.R.mb && this.R.mb.Va() ? this.R.mb : p
        },
        getDistance: function(a, b) {
            if (a && b) {
                if (a.lb(b)) return 0;
                var c = 0,
                    c = R.So(a, b);
                if (c === p || c === j) c = 0;
                return c
            }
        },
        qx: function() {
            var a = [],
                b = this.ua,
                c = this.ze;
            if (b)
                for (var d in b) b[d] instanceof fb && a.push(b[d]);
            if (c) {
                d = 0;
                for (b = c.length; d < b; d++) a.push(c[d])
            }
            return a
        },
        va: t("Hb"),
        oz: function() {
            for (var a = this.R.WE; a < z.yr.length; a++) z.yr[a](this);
            this.R.WE = a
        },
        kF: function(a) {
            this.Vb = Na.rk(a);
            this.Bw = Na.ZK(this.Vb);
            this.Hb === Na && this.we instanceof gb && (this.we.gj = this.Vb)
        },
        setDefaultCursor: function(a) {
            this.M.Wb = a;
            this.platform && (this.platform.style.cursor = this.M.Wb)
        },
        getDefaultCursor: function() {
            return this.M.Wb
        },
        setDraggingCursor: function(a) {
            this.M.Cd = a
        },
        getDraggingCursor: function() {
            return this.M.Cd
        },
        AL: function() {
            return this.M.eW && 1.5 <= this.M.devicePixelRatio
        },
        nw: function(a, b) {
            b ? this.Nh[b] || (this.Nh[b] = {}) : b = "custom";
            a.tag = b;
            a instanceof hb && (this.Nh[b][a.ca] = a, a.pa(this));
            var c = this;
            I.load("hotspot", function() {
                c.oz()
            }, o)
        },
        aZ: function(a, b) {
            b || (b = "custom");
            this.Nh[b][a.ca] && delete this.Nh[b][a.ca]
        },
        Yl: function(a) {
            a || (a = "custom");
            this.Nh[a] = {}
        },
        Su: function() {
            var a = this.Hb.Uo(),
                b = this.Hb.mm(),
                c = this.M;
            c.dc = c.wO || a;
            c.Yb = c.vO || b;
            c.dc < a && (c.dc = a);
            c.Yb > b && (c.Yb = b)
        },
        setMinZoom: function(a) {
            a = Math.round(a);
            a > this.M.Yb && (a = this.M.Yb);
            this.M.wO = a;
            this.dJ()
        },
        setMaxZoom: function(a) {
            a = Math.round(a);
            a < this.M.dc && (a = this.M.dc);
            this.M.vO = a;
            this.dJ()
        },
        dJ: function() {
            this.Su();
            var a = this.M;
            this.Ga < a.dc ? this.Nc(a.dc) : this.Ga > a.Yb && this.Nc(a.Yb);
            var b = new N("onzoomspanchange");
            b.dc = a.dc;
            b.Yb = a.Yb;
            this.dispatchEvent(b)
        },
        v2: t("JB"),
        getKey: function() {
            return pa
        },
        Nt: function(a) {
            var b = this;
            window.MPC_Mgr && window.MPC_Mgr[b.ca] && window.MPC_Mgr[b.ca].close();
            b.M.nj = q;
            z.Ij("cus.fire", "count", "z_setmapstylecount");
            if (a) {
                b = this;
                a.styleJson && (a.styleStr = b.d_(a.styleJson));
                G() && x.ea.vN ? setTimeout(function() {
                    b.M.te = a;
                    b.dispatchEvent(new N("onsetcustomstyles", a))
                }, 50) : (this.M.te = a, this.dispatchEvent(new N("onsetcustomstyles", a)), this.LL(b.M.te.geotableId));
                var c = {
                    style: a.style
                };
                a.features && 0 < a.features.length && (c.features = o);
                a.styleJson && 0 < a.styleJson.length && (c.styleJson = o);
                Oa(5050, c);
                a.style && (c = b.M.$l[a.style] ? b.M.$l[a.style].backColor : b.M.$l.normal.backColor) && (this.Na().style.backgroundColor = c)
            }
        },
        OX: function(a) {
            this.controls || (this.controls = {
                navigationControl: new ib,
                scaleControl: new jb,
                overviewMapControl: new kb,
                mapTypeControl: new lb
            });
            var b = this,
                c;
            for (c in this.controls) b.jN(b.controls[c]);
            a = a || [];
            x.jc.Db(a, function(a) {
                b.lw(b.controls[a])
            })
        },
        LL: function(a) {
            a ? this.js && this.js.xf === a || (this.yh(this.js), this.js = new mb({
                geotableId: a
            }), this.Yg(this.js)) : this.yh(this.js)
        },
        Ub: function() {
            var a = this.fa() >= this.M.JF && this.va() === La && 18 >= this.fa(),
                b = q;
            try {
                document.createElement("canvas").getContext("2d"), b = o
            } catch (c) {
                b = q
            }
            return a && b
        },
        getCurrentCity: function() {
            return {
                name: this.$g,
                code: this.Zr
            }
        },
        nm: function() {
            this.P.Xn();
            return this.P
        },
        setPanorama: function(a) {
            this.P = a;
            this.P.lF(this)
        },
        d_: function(a) {
            for (var b = {
                    featureType: "t",
                    elementType: "e",
                    visibility: "v",
                    color: "c",
                    lightness: "l",
                    saturation: "s",
                    weight: "w",
                    zoom: "z",
                    hue: "h"
                }, c = {
                    all: "all",
                    geometry: "g",
                    "geometry.fill": "g.f",
                    "geometry.stroke": "g.s",
                    labels: "l",
                    "labels.text.fill": "l.t.f",
                    "labels.text.stroke": "l.t.s",
                    "lables.text": "l.t",
                    "labels.icon": "l.i"
                }, d = [], e = 0, f; f = a[e]; e++) {
                var g = f.stylers;
                delete f.stylers;
                x.extend(f, g);
                var g = [],
                    i;
                for (i in b) f[i] && ("elementType" === i ? g.push(b[i] + ":" + c[f[i]]) : g.push(b[i] + ":" + f[i]));
                2 < g.length && d.push(g.join("|"))
            }
            return d.join(",")
        }
    });

    function Oa(a, b) {
        if (a) {
            var b = b || {},
                c = "",
                d;
            for (d in b) c = c + "&" + d + "=" + encodeURIComponent(b[d]);
            var e = function(a) {
                    a && (nb = o, setTimeout(function() {
                        ob.src = z.Fc + "images/blank.gif?" + a.src
                    }, 50))
                },
                f = function() {
                    var a = pb.shift();
                    a && e(a)
                };
            d = (1E8 * Math.random()).toFixed(0);
            nb ? pb.push({
                src: "product=jsapi&sub_product=jsapi&v=" + z.version + "&sub_product_v=" + z.version + "&t=" + d + "&code=" + a + "&da_src=" + a + c
            }) : e({
                src: "product=jsapi&sub_product=jsapi&v=" + z.version + "&sub_product_v=" + z.version + "&t=" + d + "&code=" + a + "&da_src=" + a + c
            });
            qb || (x.K(ob, "load", function() {
                nb = q;
                f()
            }), x.K(ob, "error", function() {
                nb = q;
                f()
            }), qb = o)
        }
    }
    var nb, qb, pb = [],
        ob = new Image;
    Oa(5E3, {
        device_pixel_ratio: window.devicePixelRatio,
        platform: navigator.platform
    });
    z.FL = {
        TILE_BASE_URLS: ["ss0.baidu.com/5bwHcj7lABFU8t_jkk_Z1zRvfdw6buu", "ss0.baidu.com/5bwHcj7lABFV8t_jkk_Z1zRvfdw6buu", "ss0.baidu.com/5bwHcj7lABFS8t_jkk_Z1zRvfdw6buu", "ss0.bdstatic.com/5bwHcj7lABFT8t_jkk_Z1zRvfdw6buu", "ss0.bdstatic.com/5bwHcj7lABFY8t_jkk_Z1zRvfdw6buu"],
        TILE_ONLINE_URLS: ["ss0.bdstatic.com/8bo_dTSlR1gBo1vgoIiO_jowehsv", "ss0.bdstatic.com/8bo_dTSlRMgBo1vgoIiO_jowehsv", "ss0.bdstatic.com/8bo_dTSlRcgBo1vgoIiO_jowehsv", "ss0.bdstatic.com/8bo_dTSlRsgBo1vgoIiO_jowehsv", "ss0.bdstatic.com/8bo_dTSlQ1gBo1vgoIiO_jowehsv"],
        TIlE_PERSPECT_URLS: ["ss0.bdstatic.com/-OR1cTe9KgQFm2e88IuM_a", "ss0.bdstatic.com/-ON1cTe9KgQFm2e88IuM_a", "ss0.bdstatic.com/-OZ1cTe9KgQFm2e88IuM_a", "ss0.bdstatic.com/-OV1cTe9KgQFm2e88IuM_a"],
        geolocControl: "sp2.baidu.com/8LkJsjOpB1gCo2Kml5_Y_D3",
        TILES_YUN_HOST: ["sp0.baidu.com/-eR1bSahKgkFkRGko9WTAnF6hhy", "sp0.baidu.com/-eN1bSahKgkFkRGko9WTAnF6hhy", "sp0.baidu.com/-eZ1bSahKgkFkRGko9WTAnF6hhy", "sp0.baidu.com/-eV1bSahKgkFkRGko9WTAnF6hhy"],
        traffic: "sp0.baidu.com/7_AZsjOpB1gCo2Kml5_Y_D3",
        iw_pano: "ss0.bdstatic.com/5LUZemba_QUU8t7mm9GUKT-xh_",
        message: "sp0.baidu.com/7vo0bSba2gU2pMbgoY3K",
        baidumap: "sp0.baidu.com/80MWsjip0QIZ8tyhnq",
        wuxian: "sp0.baidu.com/6a1OdTeaKgQFm2e88IuM_a",
        pano: ["ss0.bdstatic.com/5LUZemba_QUU8t7mm9GUKT-xh_", "ss0.bdstatic.com/5LUZemfa_QUU8t7mm9GUKT-xh_", "ss0.bdstatic.com/5LUZemja_QUU8t7mm9GUKT-xh_"],
        main_domain_nocdn: {
            baidu: "sp0.baidu.com/9_Q4sjOpB1gCo2Kml5_Y_D3",
            other: "api.map.baidu.com"
        },
        main_domain_cdn: {
            baidu: ["ss0.bdstatic.com/9_Q4vHSd2RZ3otebn9fN2DJv", "ss0.baidu.com/9_Q4vXSd2RZ3otebn9fN2DJv", "ss0.bdstatic.com/9_Q4vnSd2RZ3otebn9fN2DJv"],
            other: ["api.map.baidu.com"],
            webmap: ["ss0.baidu.com/6b1IcTe9R1gBo1vgoIiO_jowehsv"]
        },
        map_click: "sp0.baidu.com/80MWbzKh2wt3n2qy8IqW0jdnxx1xbK",
        vector_traffic: "ss0.bdstatic.com/8aZ1cTe9KgQIm2_p8IuM_a"
    };
    z.JX = {
        TILE_BASE_URLS: ["shangetu0.map.bdimg.com", "shangetu1.map.bdimg.com", "shangetu2.map.bdimg.com", "shangetu3.map.bdimg.com", "shangetu4.map.bdimg.com"],
        TILE_ONLINE_URLS: ["online0.map.bdimg.com", "online1.map.bdimg.com", "online2.map.bdimg.com", "online3.map.bdimg.com", "online4.map.bdimg.com"],
        TIlE_PERSPECT_URLS: ["d0.map.baidu.com", "d1.map.baidu.com", "d2.map.baidu.com", "d3.map.baidu.com"],
        geolocControl: "loc.map.baidu.com",
        TILES_YUN_HOST: ["g0.api.map.baidu.com", "g1.api.map.baidu.com", "g2.api.map.baidu.com", "g3.api.map.baidu.com"],
        traffic: "its.map.baidu.com",
        iw_pano: "pcsv0.map.bdimg.com",
        message: "j.map.baidu.com",
        baidumap: "map.baidu.com",
        wuxian: "wuxian.baidu.com",
        pano: ["pcsv0.map.bdimg.com", "pcsv1.map.bdimg.com", "pcsv2.map.bdimg.com"],
        main_domain_nocdn: {
            //baidu: "api.map.baidu.com"
            baidu:"123.56.133.43/bmap/a.php"
        },
        main_domain_cdn: {
            //baidu: ["api0.map.bdimg.com", "api1.map.bdimg.com", "api2.map.bdimg.com"],
            baidu:["123.56.133.43/bmap"],
            webmap: ["webmap0.map.bdimg.com"]
        },
        map_click: "mapclick.map.baidu.com",
        vector_traffic: "or.map.bdimg.com"
    };
    z.G_ = {
        "0": {
            proto: "http://",
            domain: z.JX
        },
        1: {
            proto: "https://",
            domain: z.FL
        },
        2: {
            proto: "https://",
            domain: z.FL
        }
    };
    z.ou = window.HOST_TYPE || "0";
    z.url = z.G_[z.ou];
    z.mp = z.url.proto + z.url.domain.baidumap + "/";
    z.Fc = z.url.proto + ("2" == z.ou ? z.url.domain.main_domain_nocdn.other : z.url.domain.main_domain_nocdn.baidu) + "/";
    z.ma = z.url.proto + ("2" == z.ou ? z.url.domain.main_domain_cdn.other[0] : z.url.domain.main_domain_cdn.baidu[0]) + "/";
    z.ej = z.url.proto + z.url.domain.main_domain_cdn.webmap[0] + "/";
    z.tg = function(a, b) {
        var c, d, b = b || "";
        switch (a) {
            case "main_domain_nocdn":
                c = z.Fc + b;
                break;
            case "main_domain_cdn":
                c = z.ma + b;
                break;
            default:
                d = z.url.domain[a], "[object Array]" == Object.prototype.toString.call(d) ? (c = [], x.jc.Db(d, function(a, d) {
                    c[d] = z.url.proto + a + "/" + b
                })) : c = z.url.proto + z.url.domain[a] + "/" + b
        }
        return c
    };

    function rb(a) {
        var b = {
            duration: 1E3,
            Gc: 30,
            Fo: 0,
            hc: sb.gM,
            yt: s()
        };
        this.Zf = [];
        if (a)
            for (var c in a) b[c] = a[c];
        this.k = b;
        if (Ua(b.Fo)) {
            var d = this;
            setTimeout(function() {
                d.start()
            }, b.Fo)
        } else b.Fo != tb && this.start()
    }
    var tb = "INFINITE";
    rb.prototype.start = function() {
        this.Lu = $a();
        this.Vz = this.Lu + this.k.duration;
        ub(this)
    };
    rb.prototype.add = function(a) {
        this.Zf.push(a)
    };

    function ub(a) {
        var b = $a();
        b >= a.Vz ? (Va(a.k.ta) && a.k.ta(a.k.hc(1)), Va(a.k.finish) && a.k.finish(), 0 < a.Zf.length && (b = a.Zf[0], b.Zf = [].concat(a.Zf.slice(1)), b.start())) : (a.ty = a.k.hc((b - a.Lu) / a.k.duration), Va(a.k.ta) && a.k.ta(a.ty), a.xF || (a.Pr = setTimeout(function() {
            ub(a)
        }, 1E3 / a.k.Gc)))
    }
    rb.prototype.stop = function(a) {
        this.xF = o;
        for (var b = 0; b < this.Zf.length; b++) this.Zf[b].stop(), this.Zf[b] = p;
        this.Zf.length = 0;
        this.Pr && (clearTimeout(this.Pr), this.Pr = p);
        this.k.yt(this.ty);
        a && (this.Vz = this.Lu, ub(this))
    };
    rb.prototype.cancel = ha(1);
    var sb = {
        gM: function(a) {
            return a
        },
        reverse: function(a) {
            return 1 - a
        },
        ZC: function(a) {
            return a * a
        },
        YC: function(a) {
            return Math.pow(a, 3)
        },
        Cs: function(a) {
            return -(a * (a - 2))
        },
        CK: function(a) {
            return Math.pow(a - 1, 3) + 1
        },
        BK: function(a) {
            return 0.5 > a ? 2 * a * a : -2 * (a - 2) * a - 1
        },
        x1: function(a) {
            return 0.5 > a ? 4 * Math.pow(a, 3) : 4 * Math.pow(a - 1, 3) + 1
        },
        y1: function(a) {
            return (1 - Math.cos(Math.PI * a)) / 2
        }
    };
    sb["ease-in"] = sb.ZC;
    sb["ease-out"] = sb.Cs;
    var F = {
        RF: 34,
        SF: 21,
        TF: new L(21, 32),
        NO: new L(10, 32),
        MO: new L(24, 36),
        LO: new L(12, 36),
        PF: new L(13, 1),
        oa: z.ma + "images/",
        E2: "http://api0.map.bdimg.com/images/",
        QF: z.ma + "images/markers_new.png",
        JO: 24,
        KO: 73,
        dC: {
            "\u5317\u4eac": {
                hy: "bj",
                m: new H(116.403874, 39.914889)
            },
            "\u4e0a\u6d77": {
                hy: "sh",
                m: new H(121.487899, 31.249162)
            },
            "\u6df1\u5733": {
                hy: "sz",
                m: new H(114.025974, 22.546054)
            },
            "\u5e7f\u5dde": {
                hy: "gz",
                m: new H(113.30765, 23.120049)
            }
        },
        fontFamily: "arial,sans-serif"
    };
    x.ea.rg ? (x.extend(F, {
        rK: "url(" + F.oa + "ruler.cur),crosshair",
        Wb: "-moz-grab",
        Cd: "-moz-grabbing"
    }), x.platform.ZL && (F.fontFamily = "arial,simsun,sans-serif")) : x.ea.UJ || x.ea.vN ? x.extend(F, {
        rK: "url(" + F.oa + "ruler.cur) 2 6,crosshair",
        Wb: "url(" + F.oa + "openhand.cur) 8 8,default",
        Cd: "url(" + F.oa + "closedhand.cur) 8 8,move"
    }) : x.extend(F, {
        rK: "url(" + F.oa + "ruler.cur),crosshair",
        Wb: "url(" + F.oa + "openhand.cur),default",
        Cd: "url(" + F.oa + "closedhand.cur),move"
    });

    function vb(a, b) {
        var c = a.style;
        c.left = b[0] + "px";
        c.top = b[1] + "px"
    }

    function wb(a) {
        0 < x.ea.la ? a.unselectable = "on" : a.style.MozUserSelect = "none"
    }

    function xb(a) {
        return a && a.parentNode && 11 !== a.parentNode.nodeType
    }

    function yb(a, b) {
        x.D.Gx(a, "beforeEnd", b);
        return a.lastChild
    }

    function zb(a) {
        for (var b = {
                left: 0,
                top: 0
            }; a && a.offsetParent;) b.left += a.offsetLeft, b.top += a.offsetTop, a = a.offsetParent;
        return b
    }

    function na(a) {
        a = window.event || a;
        a.stopPropagation ? a.stopPropagation() : a.cancelBubble = o
    }

    function Ab(a) {
        a = window.event || a;
        a.preventDefault ? a.preventDefault() : a.returnValue = q;
        return q
    }

    function oa(a) {
        na(a);
        return Ab(a)
    }

    function Bb() {
        var a = document.documentElement,
            b = document.body;
        return a && (a.scrollTop || a.scrollLeft) ? [a.scrollTop, a.scrollLeft] : b ? [b.scrollTop, b.scrollLeft] : [0, 0]
    }

    function Db(a, b) {
        if (a && b) return Math.round(Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)))
    }

    function Eb(a, b) {
        var c = [],
            b = b || function(a) {
                return a
            },
            d;
        for (d in a) c.push(d + "=" + b(a[d]));
        return c.join("&")
    }

    function K(a, b, c) {
        var d = document.createElement(a);
        c && (d = document.createElementNS(c, a));
        return x.D.jF(d, b || {})
    }

    function Ta(a) {
        if (a.currentStyle) return a.currentStyle;
        if (a.ownerDocument && a.ownerDocument.defaultView) return a.ownerDocument.defaultView.getComputedStyle(a, p)
    }

    function Va(a) {
        return "function" === typeof a
    }

    function Ua(a) {
        return "number" === typeof a
    }

    function Xa(a) {
        return "string" == typeof a
    }

    function Fb(a) {
        return "undefined" != typeof a
    }

    function Gb(a) {
        return "object" == typeof a
    }
    var Hb = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    function Ib(a) {
        var b = "",
            c, d, e = "",
            f, g = "",
            i = 0;
        f = /[^A-Za-z0-9\+\/\=]/g;
        if (!a || f.exec(a)) return a;
        a = a.replace(/[^A-Za-z0-9\+\/\=]/g, "");
        do c = Hb.indexOf(a.charAt(i++)), d = Hb.indexOf(a.charAt(i++)), f = Hb.indexOf(a.charAt(i++)), g = Hb.indexOf(a.charAt(i++)), c = c << 2 | d >> 4, d = (d & 15) << 4 | f >> 2, e = (f & 3) << 6 | g, b += String.fromCharCode(c), 64 != f && (b += String.fromCharCode(d)), 64 != g && (b += String.fromCharCode(e)); while (i < a.length);
        return b
    }
    var N = x.lang.Yy;

    function G() {
        return !(!x.platform.kE && !x.platform.ZX && !x.platform.Cm)
    }

    function Sa() {
        return !(!x.platform.ZL && !x.platform.RL && !x.platform.eY)
    }

    function $a() {
        return (new Date).getTime()
    }

    function Jb() {
        var a = document.body.appendChild(K("div"));
        a.innerHTML = '<v:shape id="vml_tester1" adj="1" />';
        var b = a.firstChild;
        if (!b.style) return q;
        b.style.behavior = "url(#default#VML)";
        b = b ? "object" === typeof b.adj : o;
        a.parentNode.removeChild(a);
        return b
    }

    function Kb() {
        return !!document.implementation.hasFeature("http://www.w3.org/TR/SVG11/feature#Shape", "1.1")
    }

    function Lb() {
        return !!K("canvas").getContext
    }

    function Mb(a) {
        return a * Math.PI / 180
    }
    z.nY = function() {
        var a = o,
            b = o,
            c = o,
            d = o,
            e = 0,
            f = 0,
            g = 0,
            i = 0;
        return {
            sQ: function() {
                e += 1;
                a && (a = q, setTimeout(function() {
                    Oa(5054, {
                        pic: e
                    });
                    a = o;
                    e = 0
                }, 1E4))
            },
            k0: function() {
                f += 1;
                b && (b = q, setTimeout(function() {
                    Oa(5055, {
                        move: f
                    });
                    b = o;
                    f = 0
                }, 1E4))
            },
            m0: function() {
                g += 1;
                c && (c = q, setTimeout(function() {
                    Oa(5056, {
                        zoom: g
                    });
                    c = o;
                    g = 0
                }, 1E4))
            },
            l0: function(a) {
                i += a;
                d && (d = q, setTimeout(function() {
                    Oa(5057, {
                        tile: i
                    });
                    d = o;
                    i = 0
                }, 5E3))
            }
        }
    }();
    var Za;
    (function() {
        function a(a) {
            this.HU = a;
            this.timing = {};
            this.start = +new Date
        }

        function b(a, b) {
            if (a.length === +a.length)
                for (var c = 0, d = a.length; c < d && b.call(j, c, a[c], a) !== q; c++);
            else
                for (c in a)
                    if (a.hasOwnProperty(c) && b.call(j, c, a[c], a) === q) break
        }
        var c = [],
            d = {
                push: function(a) {
                    c.push(a);
                    if (window.localStorage && window.JSON) try {
                        localStorage.setItem("WPO_NR", JSON.stringify(c))
                    } catch (b) {}
                },
                get: function(a) {
                    var b = [];
                    if (window.localStorage) try {
                        a && localStorage.removeItem("WPO_NR")
                    } catch (d) {}
                    b = c;
                    a && (c = []);
                    return b
                }
            },
            e, f, g, i, k = {};
        (!window.localStorage || !window.JSON) && document.attachEvent && window.attachEvent("onbeforeunload", function() {
            l.send()
        });
        var l = {
            send: function(a) {
                var c = [],
                    e = [],
                    f = a || d.get(o),
                    g;
                0 < f.length && (b(f, function(d, e) {
                    var f = [];
                    b(e.timing, function(a, b) {
                        f.push('"' + a + '":' + b)
                    });
                    c.push('{"t":{' + f.join(",") + '},"a":' + e.HU + "}");
                    !g && (a && e.start) && (g = e.start)
                }), b(k, function(a, b) {
                    e.push(a + "=" + b)
                }), e.push("d=[" + c.join(",") + "]"), g ? e.push("_st=" + g) : e.push("_t=" + +new Date), f = new Image, f.src = "http://static.tieba.baidu.com/tb/pms/img/st.gif?" + e.join("&"), window["___pms_img_" + 1 * new Date] = f)
            }
        };
        a.prototype = {
            oc: function(a, b) {
                this.timing[a] = 0 <= b ? b : new Date - this.start
            },
            cu: function() {
                this.start = +new Date
            },
            lO: function() {
                this.oc("tt")
            },
            Ny: function() {
                this.oc("vt")
            },
            Um: function() {
                f && (d.push(this), d.get().length >= g && l.send())
            },
            error: s()
        };
        Za = {
            Ei: {
                cE: function(a) {
                    var b = navigator.k1 || navigator.Y2 || navigator.n4 || {
                        type: 0
                    };
                    f = Math.random() <= (a.Ym || 0.01);
                    g = a.max || 5;
                    i = a.X2 || b.type;
                    k = {
                        p: a.XY,
                        mnt: i,
                        b: 50
                    };
                    window.localStorage && (window.JSON && window.addEventListener) && (e = d.get(o), window.addEventListener("load", function() {
                        l.send(e)
                    }, q))
                },
                mk: function(b) {
                    return new a(b)
                }
            }
        }
    })();
    Za.Ei.cE({
        XY: 18,
        Ym: 0.1,
        max: 1
    });
    z.bq = {
        eG: "#83a1ff",
        dq: "#808080"
    };

    function Nb(a, b, c) {
        b.Jm || (b.Jm = [], b.handle = {});
        b.Jm.push({
            filter: c,
            im: a
        });
        b.addEventListener || (b.addEventListener = function(a, c) {
            b.attachEvent("on" + a, c)
        });
        b.handle.click || (b.addEventListener("click", function(a) {
            for (var c = a.target || a.srcElement; c != b;) {
                Ob(b.Jm, function(b, g) {
                    RegExp(g.filter).test(c.getAttribute("filter")) && g.im.call(c, a, c.getAttribute("filter"))
                });
                c = c.parentNode
            }
        }, q), b.handle.click = o)
    }

    function Ob(a, b) {
        for (var c = 0, d = a.length; c < d; c++) b(c, a[c])
    }
    "2" !== z.ou && (function(a, b, c) {
        (function(a, b, c) {
            function g(a) {
                if (!a.Eo) {
                    for (var c = o, d = [], f = a.eZ, i = 0; f && i < f.length; i++) {
                        var k = f[i],
                            l = fa[k] = fa[k] || {};
                        if (l.Eo || l == a) d.push(l.Mc);
                        else {
                            c = q;
                            if (!l.IV && (k = (ta.get("alias") || {})[k] || k + ".js", !J[k])) {
                                J[k] = o;
                                var m = b.createElement("script"),
                                    n = b.getElementsByTagName("script")[0];
                                    // console.log(b);
                                m.async = o;
                                m.src = k;
                                n.parentNode.insertBefore(m, n)
                            }
                            l.Oy = l.Oy || {};
                            l.Oy[a.name] = a
                        }
                    }
                    if (c) {
                        a.Eo = o;
                        a.jK && (a.Mc = a.jK.apply(a, d));
                        for (var u in a.Oy) g(a.Oy[u])
                    }
                }
            }

            function i(a) {
                return (a || new Date) - D
            }

            function k(a, b, c) {
                if (a) {
                    "string" == typeof a && (c = b, b = a, a = O);
                    try {
                        a == O ? (M[b] = M[b] || [], M[b].unshift(c)) : a.addEventListener ? a.addEventListener(b, c, q) : a.attachEvent && a.attachEvent("on" + b, c)
                    } catch (d) {}
                }
            }

            function l(a, b, c) {
                if (a) {
                    "string" == typeof a && (c = b, b = a, a = O);
                    try {
                        if (a == O) {
                            var d = M[b];
                            if (d)
                                for (var e = d.length; e--;) d[e] === c && d.splice(e, 1)
                        } else a.removeEventListener ? a.removeEventListener(b, c, q) : a.detachEvent && a.detachEvent("on" + b, c)
                    } catch (f) {}
                }
            }

            function m(a) {
                var b = M[a],
                    c = 0;
                if (b) {
                    for (var d = [], e = arguments, f = 1; f < e.length; f++) d.push(e[f]);
                    for (f = b.length; f--;) b[f].apply(this, d) && c++;
                    return c
                }
            }

            function n(a, b) {
                if (a && b) {
                    var c = new Image(1, 1),
                        d = [],
                        e = "img_" + +new Date,
                        f;
                    for (f in b) b[f] && d.push(f + "=" + encodeURIComponent(b[f]));
                    O[e] = c;
                    c.onload = c.onerror = function() {
                        O[e] = c = c.onload = c.onerror = p;
                        delete O[e]
                    };
                    c.src = a + "?" + d.join("&")
                }
            }

            function u() {
                var a = arguments,
                    b = a[0];
                if (this.iK || /^(on|un|set|get|create)$/.test(b)) {
                    for (var b = w.prototype[b], c = [], d = 1, e = a.length; d < e; d++) c.push(a[d]);
                    "function" == typeof b && b.apply(this, c)
                } else this.HJ.push(a)
            }

            function v(a, b) {
                var c = {},
                    d;
                for (d in a) a.hasOwnProperty(d) && (c[d] = a[d]);
                for (d in b) b.hasOwnProperty(d) && (c[d] = b[d]);
                return c
            }

            function w(a) {
                this.name = a;
                this.Hs = {
                    TE: {
                        jy: p,
                        TE: p
                    }
                };
                this.HJ = []
            }

            function y(a) {
                a = a || "default";
                if ("*" == a) {
                    var a = [],
                        b;
                    for (b in ea) a.push(ea[b]);
                    return a
                }(b = ea[a]) || (b = ea[a] = new w(a));
                return b
            }
            var B = c.alog;
            if (!B || !B.Eo) {
                var A = b.all && a.attachEvent,
                    D = B && B.sE || +new Date,
                    C = a.Q2 || (+new Date).toString(36) + Math.random().toString(36).substr(2, 3),
                    E = 0,
                    J = {},
                    O = function(a) {
                        var b = arguments,
                            c, d, e, f;
                        if ("define" == a || "require" == a) {
                            for (d = 1; d < b.length; d++) switch (typeof b[d]) {
                                case "string":
                                    c = b[d];
                                    break;
                                case "object":
                                    e = b[d];
                                    break;
                                case "function":
                                    f = b[d]
                            }
                            "require" == a && (c && !e && (e = [c]), c = p);
                            c = !c ? "#" + E++ : c;
                            d = fa[c] = fa[c] || {};
                            d.Eo || (d.name = c, d.eZ = e, d.jK = f, "define" == a && (d.IV = o), g(d))
                        } else "function" == typeof a ? a(O) : ("" + a).replace(/^(?:([\w$_]+)\.)?(\w+)$/, function(a, c, d) {
                            b[0] = d;
                            u.apply(O.kO(c), b)
                        })
                    },
                    M = {},
                    ea = {},
                    fa = {
                        T0: {
                            name: "alog",
                            Eo: o,
                            Mc: O
                        }
                    };
                w.prototype.start = w.prototype.create = function(a) {
                    if (!this.iK) {
                        "object" == typeof a && this.set(a);
                        this.iK = new Date;
                        for (this.Is("create", this); a = this.HJ.shift();) u.apply(this, a)
                    }
                };
                w.prototype.send = function(a, b) {
                    var c = v({
                        ts: i().toString(36),
                        t: a,
                        sid: C
                    }, this.Hs);
                    if ("object" == typeof b) c = v(c, b);
                    else {
                        var d = arguments;
                        switch (a) {
                            case "pageview":
                                d[1] && (c.page = d[1]);
                                d[2] && (c.title = d[2]);
                                break;
                            case "event":
                                d[1] && (c.eventCategory = d[1]);
                                d[2] && (c.eventAction = d[2]);
                                d[3] && (c.eventLabel = d[3]);
                                d[4] && (c.eventValue = d[4]);
                                break;
                            case "timing":
                                d[1] && (c.timingCategory = d[1]);
                                d[2] && (c.timingVar = d[2]);
                                d[3] && (c.timingValue = d[3]);
                                d[4] && (c.timingLabel = d[4]);
                                break;
                            case "exception":
                                d[1] && (c.exDescription = d[1]);
                                d[2] && (c.exFatal = d[2]);
                                break;
                            default:
                                return
                        }
                    }
                    this.Is("send", c);
                    var e;
                    if (d = this.Hs.TE) {
                        var f = {};
                        for (e in c) d[e] !== p && (f[d[e] || e] = c[e]);
                        e = f
                    } else e = c;
                    n(this.Hs.jy, e)
                };
                w.prototype.set = function(a, b) {
                    if ("string" == typeof a) "protocolParameter" == a && (b = v({
                        jy: p,
                        TE: p
                    }, b)), this.Hs[a] = b;
                    else if ("object" == typeof a)
                        for (var c in a) this.set(c, a[c])
                };
                w.prototype.get = function(a, b) {
                    var c = this.Hs[a];
                    "function" == typeof b && b(c);
                    return c
                };
                w.prototype.Is = function(a, b) {
                    return O.Is(this.name + "." + a, b)
                };
                w.prototype.K = function(a, b) {
                    O.K(this.name + "." + a, b)
                };
                w.prototype.bd = function(a, b) {
                    O.bd(this.name + "." + a, b)
                };
                w.prototype.start = w.prototype.start;
                w.prototype.create = w.prototype.create;
                w.prototype.send = w.prototype.send;
                w.prototype.set = w.prototype.set;
                w.prototype.get = w.prototype.get;
                w.prototype.fire = w.prototype.Is;
                w.prototype.on = w.prototype.K;
                w.prototype.un = w.prototype.bd;
                O.name = "alog";
                O.NN = C;
                O.Eo = o;
                O.timestamp = i;
                O.bd = l;
                O.K = k;
                O.Is = m;
                O.kO = y;
                O("init");
                var ta = y();
                ta.set("protocolParameter", {
                    S0: p
                });
                if (B) {
                    var Qa = [].concat(B.yb || [], B.Tm || []);
                    B.yb = B.Tm = p;
                    for (var cb in O) O.hasOwnProperty(cb) && (B[cb] = O[cb]);
                    O.yb = O.Tm = {
                        push: function(a) {
                            O.apply(O, a)
                        }
                    };
                    for (B = 0; B < Qa.length; B++) O.apply(O, Qa[B])
                }
                c.alog = O;
                A && k(b, "mouseup", function(a) {
                    a = a.target || a.srcElement;
                    1 == a.nodeType && /^ajavascript:/i.test(a.tagName + a.href)
                });
                var Ya = q;
                a.onerror = function(a, b, d, e) {
                    var g = o;
                    !b && /^script error/i.test(a) && (Ya ? g = q : Ya = o);
                    g && c.alog("exception.send", "exception", {
                        EM: a,
                        fY: b,
                        iM: d,
                        h1: e
                    });
                    return q
                };
                c.alog("exception.on", "catch", function(a) {
                    c.alog("exception.send", "exception", {
                        EM: a.EM,
                        fY: a.path,
                        iM: a.iM,
                        method: a.method,
                        pW: "catch"
                    })
                })
            }
        })(a, b, c);
        (function(a, b, c) {
            var g = "18_1";
            G() && (g = "18_2");
            var i = Math.random,
                k = {
                    Ym: "0.1"
                },
                l = {
                    Ym: "0.1"
                };
            if (k && k.Ym && i() < k.Ym) {
                var m = c.alog.kO("monkey"),
                    n, a = a.screen,
                    b = b.referrer;
                m.set("ver", 5);
                m.set("pid", 241);
                a && m.set("px", a.width + "*" + a.height);
                m.set("ref", b);
                c.alog("monkey.on", "create", function() {
                    n = c.alog.timestamp;
                    m.set("protocolParameter", {
                        reports: p
                    })
                });
                c.alog("monkey.on", "send", function(a) {
                    "pageview" == a.t && (a.cmd = "open");
                    a.now && (a.ts = n(a.now).toString(36), a.now = "")
                });
                c.alog("monkey.create", {
                    page: g,
                    pid: "241",
                    p: "18",
                    jy: "http://nsclick.baidu.com/u.gif",
                    y3: {
                        w3: 1
                    }
                });
                c.alog("monkey.send", "pageview", {
                    now: +new Date
                })
            }
            l && (l.Ym && i() < l.Ym) && (c.alog("cus.on", "time", function(a) {
                var b = {},
                    d = q,
                    e;
                if ("[object Object]" === a.toString()) {
                    for (var g in a) "page" == g ? b.page = a[g] : (e = parseInt(a[g], 10), 0 < e && /^z_/.test(g) && (d = o, b[g] = e));
                    d && c.alog("cus.send", "time", b)
                }
            }), c.alog("cus.on", "count", function(a) {
                var b = {},
                    d = q;
                "string" === typeof a && (a = [a]);
                if (a instanceof Array)
                    for (var e = 0; e < a.length; e++) /^z_/.test(a[e]) ? (d = o, b[a[e]] = 1) : /^page:/.test(a[e]) && (b.page = a[e].substring(5));
                d && c.alog("cus.send", "count", b)
            }), c.alog("cus.create", {
                dv: 3,
                jy: "http://static.tieba.baidu.com/tb/pms/img/st.gif",
                page: g,
                p: "18"
            }))
        })(a, b, c)
    }(window, document, z), z.alog("cus.fire", "count", "z_loadscriptcount"));
    z.Ij = z.alog || s();

    function Pb(a, b) {
        if (b) {
            var c = (1E5 * Math.random()).toFixed(0);
            z._rd["_cbk" + c] = function(a) {
                b && b(a);
                delete z._rd["_cbk" + c]
            };
            a += "&callback=BMap._rd._cbk" + c
        }
        var d = K("script", {
            type: "text/javascript"
        });
        d.charset = "utf-8";
        d.src = a;
        d.addEventListener ? d.addEventListener("load", function(a) {
            a = a.target;
            a.parentNode.removeChild(a)
        }, q) : d.attachEvent && d.attachEvent("onreadystatechange", function() {
            var a = window.event.srcElement;
            a && ("loaded" == a.readyState || "complete" == a.readyState) && a.parentNode.removeChild(a)
        });
        setTimeout(function() {
            document.getElementsByTagName("head")[0].appendChild(d);
            //console.log(d);
            d = p
        }, 1)
    };
    var Qb = {
        map: "akh2y0",
        common: "ryiabv",
        style: "fcoka2",
        tile: "4jizpw",
        vectordrawlib: "edd0e5",
        newvectordrawlib: "usvn5i",
        groundoverlay: "isogiu",
        pointcollection: "ywvyea",
        marker: "nswzox",
        symbol: "w1ckay",
        canvablepath: "xopozg",
        vmlcontext: "g2vl52",
        markeranimation: "wcz3cm",
        poly: "iddsa3",
        draw: "0cs0rt",
        drawbysvg: "kki2w3",
        drawbyvml: "y0taqr",
        drawbycanvas: "y0e5ow",
        infowindow: "wwsgrs",
        oppc: "rr41qw",
        opmb: "yu3ytg",
        menu: "eivkds",
        control: "iwukxb",
        navictrl: "h5anny",
        geoctrl: "ncf55j",
        copyrightctrl: "gzfon1",
        citylistcontrol: "2vfa0z",
        scommon: "difgzt",
        local: "1g2nla",
        route: "zgjx20",
        othersearch: "g4ttvp",
        mapclick: "upjylc",
        buslinesearch: "5yliba",
        hotspot: "sn350a",
        autocomplete: "ixdcxk",
        coordtrans: "v5wceh",
        coordtransutils: "n2quqi",
        convertor: "aq35qq",
        clayer: "tlofrw",
        pservice: "4af0ju",
        pcommon: "2q0hoz",
        panorama: "wrjp2y",
        panoramaflash: "4hpzqc",
        vector: "rlm4gs"
    };
    x.Hy = function() {
        function a(a) {
            return d && !!c[b + a + "_" + Qb[a]]
        }
        var b = "BMap_",
            c = window.localStorage,
            d = "localStorage" in window && c !== p && c !== j;
        return {
            aY: d,
            set: function(a, f) {
                if (d) {
                    for (var g = b + a + "_", i = c.length, k; i--;) k = c.key(i), -1 < k.indexOf(g) && c.removeItem(k);
                    try {
                        c.setItem(b + a + "_" + Qb[a], f)
                    } catch (l) {
                        c.clear()
                    }
                }
            },
            get: function(e) {
                return d && a(e) ? c.getItem(b + e + "_" + Qb[e]) : q
            },
            SJ: a
        }
    }();

    function I() {}
    x.object.extend(I, {
        Fj: {
            fG: -1,
            sP: 0,
            Xp: 1
        },
        cL: function() {
            var a = "drawbysvg",
                b = "canvablepath",
                c = z.mJ ? "newvectordrawlib" : "vectordrawlib";
            G() && Lb() ? a = "drawbycanvas" : Kb() ? a = "drawbysvg" : Jb() ? (a = "drawbyvml", b = "vmlcontext") : Lb() && (a = "drawbycanvas");
            return {
                tile: [c, "style"],
                control: [],
                marker: ["symbol"],
                symbol: ["canvablepath", "common"],
                canvablepath: "canvablepath" === b ? [] : [b],
                vmlcontext: [],
                style: [],
                poly: ["marker", a],
                drawbysvg: ["draw"],
                drawbyvml: ["draw"],
                drawbycanvas: ["draw"],
                infowindow: ["common", "marker"],
                menu: [],
                oppc: [],
                opmb: [],
                scommon: [],
                local: ["scommon"],
                route: ["scommon"],
                othersearch: ["scommon"],
                autocomplete: ["scommon"],
                citylistcontrol: ["autocomplete"],
                mapclick: ["scommon"],
                buslinesearch: ["route"],
                hotspot: [],
                coordtransutils: ["coordtrans"],
                convertor: [],
                clayer: ["tile"],
                pservice: [],
                pcommon: ["style", "pservice"],
                panorama: ["pcommon"],
                panoramaflash: ["pcommon"]
            }
        },
        o3: {},
        ZF: {
            //JP: z.ma + "getmodules.php?v=2.0&t=20140707",
            JP: z.ma + "",
            kU: 5E3
        },
        AC: q,
        Nd: {
            nl: {},
            Bn: [],
            Pv: []
        },
        load: function(a, b, c) {
            var d = this.gb(a);
            // console.log(d);
            if (d.Ad == this.Fj.Xp) c && b();
            else {
                if (d.Ad == this.Fj.fG) {
                    this.ZJ(a);
                    this.gN(a);
                    var e = this;
                    e.AC == q && (e.AC = o, setTimeout(function() {
                        for (var a = [], b = 0, c = e.Nd.Bn.length; b < c; b++) {
                            var d = e.Nd.Bn[b],
                                l = "";
                            ja.Hy.SJ(d) ? l = ja.Hy.get(d) : (l = "", a.push(d + "_" + Qb[d]));
                            e.Nd.Pv.push({
                                AM: d,
                                EE: l
                            })
                        }
                        e.AC = q;
                        e.Nd.Bn.length = 0;                      
                        0 == a.length ? e.IK() : Pb(e.ZF.JP + "&mod=" + a.join(","));

                    }, 1));
                    d.Ad = this.Fj.sP
                }
                d.Pu.push(b);
            }
        },
        ZJ: function(a) {
            if (a && this.cL()[a])
                for (var a = this.cL()[a], b = 0; b < a.length; b++) this.ZJ(a[b]), this.Nd.nl[a[b]] || this.gN(a[b])
        },
        gN: function(a) {
            for (var b = 0; b < this.Nd.Bn.length; b++)
                if (this.Nd.Bn[b] == a) return;
            this.Nd.Bn.push(a)
        },
        kZ: function(a, b) {
            var c = this.gb(a);
            try {
                eval(b)
            } catch (d) {
                return
            }
            c.Ad = this.Fj.Xp;
            for (var e = 0, f = c.Pu.length; e < f; e++) c.Pu[e]();
            c.Pu.length = 0
        },
        SJ: function(a, b) {
            var c = this;
            c.timeout = setTimeout(function() {
                c.Nd.nl[a].Ad != c.Fj.Xp ? (c.remove(a), c.load(a, b)) : clearTimeout(c.timeout)
            }, c.ZF.kU)
        },
        gb: function(a) {
            this.Nd.nl[a] || (this.Nd.nl[a] = {}, this.Nd.nl[a].Ad = this.Fj.fG, this.Nd.nl[a].Pu = []);
            return this.Nd.nl[a]
        },
        remove: function(a) {
            delete this.gb(a)
        },
        cV: function(a, b) {
            for (var c = this.Nd.Pv, d = o, e = 0, f = c.length; e < f; e++) "" == c[e].EE && (c[e].AM == a ? c[e].EE = b : d = q);
            d && this.IK()
        },
        IK: function() {
            for (var a = this.Nd.Pv, b = 0, c = a.length; b < c; b++) this.kZ(a[b].AM, a[b].EE);
            this.Nd.Pv.length = 0
        }
    });

    function Q(a, b) {
        this.x = a || 0;
        this.y = b || 0;
        this.x = this.x;
        this.y = this.y
    }
    Q.prototype.lb = function(a) {
        return a && a.x == this.x && a.y == this.y
    };

    function L(a, b) {
        this.width = a || 0;
        this.height = b || 0
    }
    L.prototype.lb = function(a) {
        return a && this.width == a.width && this.height == a.height
    };

    function hb(a, b) {
        a && (this.Kb = a, this.ca = "spot" + hb.ca++, b = b || {}, this.Vg = b.text || "", this.wv = b.offsets ? b.offsets.slice(0) : [5, 5, 5, 5], this.fJ = b.userData || p, this.Ph = b.minZoom || p, this.Cf = b.maxZoom || p)
    }
    hb.ca = 0;
    x.extend(hb.prototype, {
        pa: function(a) {
            this.Ph == p && (this.Ph = a.M.dc);
            this.Cf == p && (this.Cf = a.M.Yb)
        },
        ra: function(a) {
            a instanceof H && (this.Kb = a)
        },
        ha: t("Kb"),
        Rt: ba("Vg"),
        RD: t("Vg"),
        setUserData: ba("fJ"),
        getUserData: t("fJ")
    });

    function Rb() {
        this.C = p;
        this.Lb = "control";
        this.Pa = this.LJ = o
    }
    x.lang.sa(Rb, x.lang.Ba, "Control");
    x.extend(Rb.prototype, {
        initialize: function(a) {
            this.C = a;
            if (this.B) return a.Ua.appendChild(this.B), this.B
        },
        Ce: function(a) {
            !this.B && (this.initialize && Va(this.initialize)) && (this.B = this.initialize(a));
            this.k = this.k || {
                Ag: q
            };
            this.uB();
            this.Hr();
            this.B && (this.B.fr = this)
        },
        uB: function() {
            var a = this.B;
            if (a) {
                var b = a.style;
                b.position = "absolute";
                b.zIndex = this.tz || "10";
                b.MozUserSelect = "none";
                b.WebkitTextSizeAdjust = "none";
                this.k.Ag || x.D.Ta(a, "BMap_noprint");
                G() || x.K(a, "contextmenu", oa)
            }
        },
        remove: function() {
            this.C = p;
            this.B && (this.B.parentNode && this.B.parentNode.removeChild(this.B), this.B = this.B.fr = p)
        },
        za: function() {
            this.B = yb(this.C.Ua, "<div unselectable='on'></div>");
            this.Pa == q && x.D.U(this.B);
            return this.B
        },
        Hr: function() {
            this.pc(this.k.anchor)
        },
        pc: function(a) {
            if (this.U0 || !Ua(a) || isNaN(a) || a < Sb || 3 < a) a = this.defaultAnchor;
            this.k = this.k || {
                Ag: q
            };
            this.k.ya = this.k.ya || this.defaultOffset;
            var b = this.k.anchor;
            this.k.anchor = a;
            if (this.B) {
                var c = this.B,
                    d = this.k.ya.width,
                    e = this.k.ya.height;
                c.style.left = c.style.top = c.style.right = c.style.bottom = "auto";
                switch (a) {
                    case Sb:
                        c.style.top = e + "px";
                        c.style.left = d + "px";
                        break;
                    case Tb:
                        c.style.top = e + "px";
                        c.style.right = d + "px";
                        break;
                    case Ub:
                        c.style.bottom = e + "px";
                        c.style.left = d + "px";
                        break;
                    case 3:
                        c.style.bottom = e + "px", c.style.right = d + "px"
                }
                c = ["TL", "TR", "BL", "BR"];
                x.D.Rb(this.B, "anchor" + c[b]);
                x.D.Ta(this.B, "anchor" + c[a])
            }
        },
        vD: function() {
            return this.k.anchor
        },
        Ue: function(a) {
            a instanceof L && (this.k = this.k || {
                Ag: q
            }, this.k.ya = new L(a.width, a.height), this.B && this.pc(this.k.anchor))
        },
        Pf: function() {
            return this.k.ya
        },
        Fd: t("B"),
        show: function() {
            this.Pa != o && (this.Pa = o, this.B && x.D.show(this.B))
        },
        U: function() {
            this.Pa != q && (this.Pa = q, this.B && x.D.U(this.B))
        },
        isPrintable: function() {
            return !!this.k.Ag
        },
        lh: function() {
            return !this.B && !this.C ? q : !!this.Pa
        }
    });
    var Sb = 0,
        Tb = 1,
        Ub = 2;

    function ib(a) {
        Rb.call(this);
        a = a || {};
        this.k = {
            Ag: q,
            tF: a.showZoomInfo || o,
            anchor: a.anchor,
            ya: a.offset,
            type: a.type,
            dW: a.enableGeolocation || q
        };
        this.defaultAnchor = G() ? 3 : Sb;
        this.defaultOffset = new L(10, 10);
        this.pc(a.anchor);
        this.fn(a.type);
        this.xe()
    }
    x.lang.sa(ib, Rb, "NavigationControl");
    x.extend(ib.prototype, {
        initialize: function(a) {
            this.C = a;
            return this.B
        },
        fn: function(a) {
            this.k.type = Ua(a) && 0 <= a && 3 >= a ? a : 0
        },
        cp: function() {
            return this.k.type
        },
        xe: function() {
            var a = this;
            I.load("navictrl", function() {
                a.uf()
            })
        }
    });

    function Vb(a) {
        Rb.call(this);
        a = a || {};
        this.k = {
            anchor: a.anchor || Ub,
            ya: a.offset || new L(10, 30),
            UZ: a.showAddressBar !== q,
            A1: a.enableAutoLocation || q,
            oM: a.locationIcon || p
        };
        var b = this;
        this.tz = 1200;
        b.I_ = [];
        this.le = [];
        I.load("geoctrl", function() {
            (function d() {
                if (0 !== b.le.length) {
                    var a = b.le.shift();
                    b[a.method].apply(b, a.arguments);
                    d()
                }
            })();
            b.IP()
        });
        Oa(Ja)
    }
    x.lang.sa(Vb, Rb, "GeolocationControl");
    x.extend(Vb.prototype, {
        location: function() {
            this.le.push({
                method: "location",
                arguments: arguments
            })
        },
        getAddressComponent: ca(p)
    });

    function Wb(a) {
        Rb.call(this);
        a = a || {};
        this.k = {
            Ag: q,
            anchor: a.anchor,
            ya: a.offset
        };
        this.ac = [];
        this.defaultAnchor = Ub;
        this.defaultOffset = new L(5, 2);
        this.pc(a.anchor);
        this.LJ = q;
        this.xe()
    }
    x.lang.sa(Wb, Rb, "CopyrightControl");
    x.object.extend(Wb.prototype, {
        initialize: function(a) {
            this.C = a;
            return this.B
        },
        mw: function(a) {
            if (a && Ua(a.id) && !isNaN(a.id)) {
                var b = {
                        bounds: p,
                        content: ""
                    },
                    c;
                for (c in a) b[c] = a[c];
                if (a = this.km(a.id))
                    for (var d in b) a[d] = b[d];
                else this.ac.push(b)
            }
        },
        km: function(a) {
            for (var b = 0, c = this.ac.length; b < c; b++)
                if (this.ac[b].id == a) return this.ac[b]
        },
        BD: t("ac"),
        XE: function(a) {
            for (var b = 0, c = this.ac.length; b < c; b++) this.ac[b].id == a && (r = this.ac.splice(b, 1), b--, c = this.ac.length)
        },
        xe: function() {
          //  var a = this;
          //  I.load("copyrightctrl", function() {
          //      a.uf()
          //  })
        }
    });

    function kb(a) {
        Rb.call(this);
        a = a || {};
        this.k = {
            Ag: q,
            size: a.size || new L(150, 150),
            padding: 5,
            Va: a.isOpen === o ? o : q,
            X_: 4,
            ya: a.offset,
            anchor: a.anchor
        };
        this.defaultAnchor = 3;
        this.defaultOffset = new L(0, 0);
        this.vq = this.wq = 13;
        this.pc(a.anchor);
        this.Jd(this.k.size);
        this.xe()
    }
    x.lang.sa(kb, Rb, "OverviewMapControl");
    x.extend(kb.prototype, {
        initialize: function(a) {
            this.C = a;
            return this.B
        },
        pc: function(a) {
            Rb.prototype.pc.call(this, a)
        },
        me: function() {
            this.me.fo = o;
            this.k.Va = !this.k.Va;
            this.B || (this.me.fo = q)
        },
        Jd: function(a) {
            a instanceof L || (a = new L(150, 150));
            a.width = 0 < a.width ? a.width : 150;
            a.height = 0 < a.height ? a.height : 150;
            this.k.size = a
        },
        wb: function() {
            return this.k.size
        },
        Va: function() {
            return this.k.Va
        },
        xe: function() {
            var a = this;
            I.load("control", function() {
                a.uf()
            })
        }
    });

    function Xb(a) {
        Rb.call(this);
        a = a || {};
        this.defaultAnchor = Sb;
        this.gj = "";
        this.defaultOffset = new L(10, 10);
        this.onChangeBefore = [];
        this.onChangeAfter = [];
        this.k = {
            Ag: q,
            ya: a.offset || this.defaultOffset,
            anchor: a.anchor || this.defaultAnchor,
            expand: !!a.expand
        };
        a.onChangeBefore && Va(a.onChangeBefore) && this.onChangeBefore.push(a.onChangeBefore);
        a.onChangeAfter && Va(a.onChangeAfter) && this.onChangeAfter.push(a.onChangeAfter);
        this.pc(a.anchor);
        this.xe()
    }
    x.lang.sa(Xb, Rb, "CityListControl");
    x.object.extend(Xb.prototype, {
        initialize: function(a) {
            this.C = a;
            return this.B
        },
        xe: function() {
            var a = this;
            I.load("citylistcontrol", function() {
                a.uf()
            }, o)
        }
    });

    function jb(a) {
        Rb.call(this);
        a = a || {};
        this.k = {
            Ag: q,
            color: "black",
            cd: "metric",
            ya: a.offset
        };
        this.defaultAnchor = Ub;
        this.defaultOffset = new L(81, 18);
        this.pc(a.anchor);
        this.Yh = {
            metric: {
                name: "metric",
                aK: 1,
                KL: 1E3,
                pO: "\u7c73",
                qO: "\u516c\u91cc"
            },
            us: {
                name: "us",
                aK: 3.2808,
                KL: 5280,
                pO: "\u82f1\u5c3a",
                qO: "\u82f1\u91cc"
            }
        };
        this.Yh[this.k.cd] || (this.k.cd = "metric");
        this.DI = p;
        this.dI = {};
        this.xe()
    }
    x.lang.sa(jb, Rb, "ScaleControl");
    x.object.extend(jb.prototype, {
        initialize: function(a) {
            this.C = a;
            return this.B
        },
        Hk: function(a) {
            this.k.color = a + ""
        },
        R1: function() {
            return this.k.color
        },
        qF: function(a) {
            this.k.cd = this.Yh[a] && this.Yh[a].name || this.k.cd
        },
        xX: function() {
            return this.k.cd
        },
        xe: function() {
            var a = this;
            I.load("control", function() {
                a.uf()
            })
        }
    });
    var Yb = 0;

    function lb(a) {
        Rb.call(this);
        a = a || {};
        this.defaultAnchor = Tb;
        this.defaultOffset = new L(10, 10);
        this.k = {
            Ag: q,
            oh: [La, Wa, Pa, Na],
            HV: ["B_DIMENSIONAL_MAP", "B_SATELLITE_MAP", "B_NORMAL_MAP"],
            type: a.type || Yb,
            ya: a.offset || this.defaultOffset,
            hW: o
        };
        this.pc(a.anchor);
        "[object Array]" == Object.prototype.toString.call(a.mapTypes) && (this.k.oh = a.mapTypes.slice(0));
        this.xe()
    }
    x.lang.sa(lb, Rb, "MapTypeControl");
    x.object.extend(lb.prototype, {
        initialize: function(a) {
            this.C = a;
            return this.B
        },
        Iy: function(a) {
            this.C.Vn = a
        },
        xe: function() {
            var a = this;
            I.load("control", function() {
                a.uf()
            }, o)
        }
    });

    function Zb(a) {
        Rb.call(this);
        a = a || {};
        this.k = {
            Ag: q,
            ya: a.offset,
            anchor: a.anchor
        };
        this.Ri = q;
        this.Tv = p;
        this.mI = new $b({
            Of: "api"
        });
        this.nI = new ac(p, {
            Of: "api"
        });
        this.defaultAnchor = Tb;
        this.defaultOffset = new L(10, 10);
        this.pc(a.anchor);
        this.xe();
        Oa(wa)
    }
    x.lang.sa(Zb, Rb, "PanoramaControl");
    x.extend(Zb.prototype, {
        initialize: function(a) {
            this.C = a;
            return this.B
        },
        xe: function() {
            var a = this;
            I.load("control", function() {
                a.uf()
            })
        }
    });

    function bc(a) {
        x.lang.Ba.call(this);
        this.k = {
            Ua: p,
            cursor: "default"
        };
        this.k = x.extend(this.k, a);
        this.Lb = "contextmenu";
        this.C = p;
        this.xa = [];
        this.Ff = [];
        this.Ae = [];
        this.Nw = this.gs = p;
        this.Oh = q;
        var b = this;
        I.load("menu", function() {
            b.vb()
        })
    }
    x.lang.sa(bc, x.lang.Ba, "ContextMenu");
    x.object.extend(bc.prototype, {
        pa: function(a, b) {
            this.C = a;
            this.sl = b || p
        },
        remove: function() {
            this.C = this.sl = p
        },
        ow: function(a) {
            if (a && !("menuitem" != a.Lb || "" == a.Vg || 0 >= a.$i)) {
                for (var b = 0, c = this.xa.length; b < c; b++)
                    if (this.xa[b] === a) return;
                this.xa.push(a);
                this.Ff.push(a)
            }
        },
        removeItem: function(a) {
            if (a && "menuitem" == a.Lb) {
                for (var b = 0, c = this.xa.length; b < c; b++) this.xa[b] === a && (this.xa[b].remove(), this.xa.splice(b, 1), c--);
                b = 0;
                for (c = this.Ff.length; b < c; b++) this.Ff[b] === a && (this.Ff[b].remove(), this.Ff.splice(b, 1), c--)
            }
        },
        PB: function() {
            this.xa.push({
                Lb: "divider",
                Oj: this.Ae.length
            });
            this.Ae.push({
                D: p
            })
        },
        ZE: function(a) {
            if (this.Ae[a]) {
                for (var b = 0, c = this.xa.length; b < c; b++) this.xa[b] && ("divider" == this.xa[b].Lb && this.xa[b].Oj == a) && (this.xa.splice(b, 1), c--), this.xa[b] && ("divider" == this.xa[b].Lb && this.xa[b].Oj > a) && this.xa[b].Oj--;
                this.Ae.splice(a, 1)
            }
        },
        Fd: t("B"),
        show: function() {
            this.Oh != o && (this.Oh = o)
        },
        U: function() {
            this.Oh != q && (this.Oh = q)
        },
        zZ: function(a) {
            a && (this.k.cursor = a)
        },
        getItem: function(a) {
            return this.Ff[a]
        }
    });
    var cc = F.oa + "menu_zoom_in.png",
        dc = F.oa + "menu_zoom_out.png";

    function ec(a, b, c) {
        if (a && Va(b)) {
            x.lang.Ba.call(this);
            this.k = {
                width: 100,
                id: "",
                ym: ""
            };
            c = c || {};
            this.k.width = 1 * c.width ? c.width : 100;
            this.k.id = c.id ? c.id : "";
            this.k.ym = c.iconUrl ? c.iconUrl : "";
            this.Vg = a + "";
            this.wz = b;
            this.C = p;
            this.Lb = "menuitem";
            this.Nr = this.lv = this.B = this.Gh = p;
            this.Kh = o;
            var d = this;
            I.load("menu", function() {
                d.vb()
            })
        }
    }
    x.lang.sa(ec, x.lang.Ba, "MenuItem");
    x.object.extend(ec.prototype, {
        pa: function(a, b) {
            this.C = a;
            this.Gh = b
        },
        remove: function() {
            this.C = this.Gh = p
        },
        Rt: function(a) {
            a && (this.Vg = a + "")
        },
        Tb: function(a) {
            a && (this.k.ym = a)
        },
        Fd: t("B"),
        enable: function() {
            this.Kh = o
        },
        disable: function() {
            this.Kh = q
        }
    });

    function eb(a, b) {
        a && !b && (b = a);
        this.Fe = this.Ee = this.Ke = this.Je = this.Hl = this.ql = p;
        a && (this.Hl = new H(a.lng, a.lat), this.ql = new H(b.lng, b.lat), this.Ke = a.lng, this.Je = a.lat, this.Fe = b.lng, this.Ee = b.lat)
    }
    x.object.extend(eb.prototype, {
        yj: function() {
            return !this.Hl || !this.ql
        },
        lb: function(a) {
            return !(a instanceof eb) || this.yj() ? q : this.re().lb(a.re()) && this.kf().lb(a.kf())
        },
        re: t("Hl"),
        kf: t("ql"),
        qV: function(a) {
            return !(a instanceof eb) || this.yj() || a.yj() ? q : a.Ke > this.Ke && a.Fe < this.Fe && a.Je > this.Je && a.Ee < this.Ee
        },
        Ka: function() {
            return this.yj() ? p : new H((this.Ke + this.Fe) / 2, (this.Je + this.Ee) / 2)
        },
        ft: function(a) {
            if (!(a instanceof eb) || Math.max(a.Ke, a.Fe) < Math.min(this.Ke, this.Fe) || Math.min(a.Ke, a.Fe) > Math.max(this.Ke, this.Fe) || Math.max(a.Je, a.Ee) < Math.min(this.Je, this.Ee) || Math.min(a.Je, a.Ee) > Math.max(this.Je, this.Ee)) return p;
            var b = Math.max(this.Ke, a.Ke),
                c = Math.min(this.Fe, a.Fe),
                d = Math.max(this.Je, a.Je),
                a = Math.min(this.Ee, a.Ee);
            return new eb(new H(b, d), new H(c, a))
        },
        bs: function(a) {
            return !(a instanceof H) || this.yj() ? q : a.lng >= this.Ke && a.lng <= this.Fe && a.lat >= this.Je && a.lat <= this.Ee
        },
        extend: function(a) {
            if (a instanceof H) {
                var b = a.lng,
                    a = a.lat;
                this.Hl || (this.Hl = new H(0, 0));
                this.ql || (this.ql = new H(0, 0));
                if (!this.Ke || this.Ke > b) this.Hl.lng = this.Ke = b;
                if (!this.Fe || this.Fe < b) this.ql.lng = this.Fe = b;
                if (!this.Je || this.Je > a) this.Hl.lat = this.Je = a;
                if (!this.Ee || this.Ee < a) this.ql.lat = this.Ee = a
            }
        },
        CF: function() {
            return this.yj() ? new H(0, 0) : new H(Math.abs(this.Fe - this.Ke), Math.abs(this.Ee - this.Je))
        }
    });

    function H(a, b) {
        isNaN(a) && (a = Ib(a), a = isNaN(a) ? 0 : a);
        Xa(a) && (a = parseFloat(a));
        isNaN(b) && (b = Ib(b), b = isNaN(b) ? 0 : b);
        Xa(b) && (b = parseFloat(b));
        this.lng = a;
        this.lat = b
    }
    H.QL = function(a) {
        return a && 180 >= a.lng && -180 <= a.lng && 74 >= a.lat && -74 <= a.lat
    };
    H.prototype.lb = function(a) {
        return a && this.lat == a.lat && this.lng == a.lng
    };

    function fc() {}
    fc.prototype.mh = function() {
        aa("lngLatToPoint\u65b9\u6cd5\u672a\u5b9e\u73b0")
    };
    fc.prototype.vi = function() {
        aa("pointToLngLat\u65b9\u6cd5\u672a\u5b9e\u73b0")
    };

    function gc() {};
    var db = {
        cK: function(a, b, c) {
            I.load("coordtransutils", function() {
                db.MU(a, b, c)
            }, o)
        },
        bK: function(a, b, c) {
            I.load("coordtransutils", function() {
                db.LU(a, b, c)
            }, o)
        }
    };

    function hc() {
        this.Oa = [];
        var a = this;
        I.load("convertor", function() {
            a.GP()
        })
    }
    x.sa(hc, x.lang.Ba, "Convertor");
    x.extend(hc.prototype, {
        translate: function(a, b, c, d) {
            this.Oa.push({
                method: "translate",
                arguments: [a, b, c, d]
            })
        }
    });
    S(hc.prototype, {
        translate: hc.prototype.translate
    });

    function R() {}
    R.prototype = new fc;
    x.extend(R, {
        XO: 6370996.81,
        jG: [1.289059486E7, 8362377.87, 5591021, 3481989.83, 1678043.12, 0],
        Au: [75, 60, 45, 30, 15, 0],
        cP: [
            [1.410526172116255E-8, 8.98305509648872E-6, -1.9939833816331, 200.9824383106796, -187.2403703815547, 91.6087516669843, -23.38765649603339, 2.57121317296198, -0.03801003308653, 1.73379812E7],
            [-7.435856389565537E-9, 8.983055097726239E-6, -0.78625201886289, 96.32687599759846, -1.85204757529826, -59.36935905485877, 47.40033549296737, -16.50741931063887, 2.28786674699375, 1.026014486E7],
            [-3.030883460898826E-8, 8.98305509983578E-6, 0.30071316287616, 59.74293618442277, 7.357984074871, -25.38371002664745, 13.45380521110908, -3.29883767235584, 0.32710905363475, 6856817.37],
            [-1.981981304930552E-8, 8.983055099779535E-6, 0.03278182852591, 40.31678527705744, 0.65659298677277, -4.44255534477492, 0.85341911805263, 0.12923347998204, -0.04625736007561, 4482777.06],
            [3.09191371068437E-9, 8.983055096812155E-6, 6.995724062E-5, 23.10934304144901, -2.3663490511E-4, -0.6321817810242, -0.00663494467273, 0.03430082397953, -0.00466043876332, 2555164.4],
            [2.890871144776878E-9, 8.983055095805407E-6, -3.068298E-8, 7.47137025468032, -3.53937994E-6, -0.02145144861037, -1.234426596E-5, 1.0322952773E-4, -3.23890364E-6, 826088.5]
        ],
        gG: [
            [-0.0015702102444, 111320.7020616939, 1704480524535203, -10338987376042340, 26112667856603880, -35149669176653700, 26595700718403920, -10725012454188240, 1800819912950474, 82.5],
            [8.277824516172526E-4, 111320.7020463578, 6.477955746671607E8, -4.082003173641316E9, 1.077490566351142E10, -1.517187553151559E10, 1.205306533862167E10, -5.124939663577472E9, 9.133119359512032E8, 67.5],
            [0.00337398766765, 111320.7020202162, 4481351.045890365, -2.339375119931662E7, 7.968221547186455E7, -1.159649932797253E8, 9.723671115602145E7, -4.366194633752821E7, 8477230.501135234, 52.5],
            [0.00220636496208, 111320.7020209128, 51751.86112841131, 3796837.749470245, 992013.7397791013, -1221952.21711287, 1340652.697009075, -620943.6990984312, 144416.9293806241, 37.5],
            [-3.441963504368392E-4, 111320.7020576856, 278.2353980772752, 2485758.690035394, 6070.750963243378, 54821.18345352118, 9540.606633304236, -2710.55326746645, 1405.483844121726, 22.5],
            [-3.218135878613132E-4, 111320.7020701615, 0.00369383431289, 823725.6402795718, 0.46104986909093, 2351.343141331292, 1.58060784298199, 8.77738589078284, 0.37238884252424, 7.45]
        ],
        W1: function(a, b) {
            if (!a || !b) return 0;
            var c, d, a = this.Fb(a);
            if (!a) return 0;
            c = this.Pk(a.lng);
            d = this.Pk(a.lat);
            b = this.Fb(b);
            return !b ? 0 : this.Qe(c, this.Pk(b.lng), d, this.Pk(b.lat))
        },
        So: function(a, b) {
            if (!a || !b) return 0;
            a.lng = this.KD(a.lng, -180, 180);
            a.lat = this.OD(a.lat, -74, 74);
            b.lng = this.KD(b.lng, -180, 180);
            b.lat = this.OD(b.lat, -74, 74);
            return this.Qe(this.Pk(a.lng), this.Pk(b.lng), this.Pk(a.lat), this.Pk(b.lat))
        },
        Fb: function(a) {
            if (a === p || a === j) return new H(0, 0);
            var b, c;
            b = new H(Math.abs(a.lng), Math.abs(a.lat));
            for (var d = 0; d < this.jG.length; d++)
                if (b.lat >= this.jG[d]) {
                    c = this.cP[d];
                    break
                }
            a = this.dK(a, c);
            return a = new H(a.lng.toFixed(6), a.lat.toFixed(6))
        },
        Eb: function(a) {
            if (a === p || a === j || 180 < a.lng || -180 > a.lng || 90 < a.lat || -90 > a.lat) return new H(0, 0);
            var b, c;
            a.lng = this.KD(a.lng, -180, 180);
            a.lat = this.OD(a.lat, -74, 74);
            b = new H(a.lng, a.lat);
            for (var d = 0; d < this.Au.length; d++)
                if (b.lat >= this.Au[d]) {
                    c = this.gG[d];
                    break
                }
            if (!c)
                for (d = this.Au.length - 1; 0 <= d; d--)
                    if (b.lat <= -this.Au[d]) {
                        c = this.gG[d];
                        break
                    }
            a = this.dK(a, c);
            return a = new H(a.lng.toFixed(2), a.lat.toFixed(2))
        },
        dK: function(a, b) {
            if (a && b) {
                var c = b[0] + b[1] * Math.abs(a.lng),
                    d = Math.abs(a.lat) / b[9],
                    d = b[2] + b[3] * d + b[4] * d * d + b[5] * d * d * d + b[6] * d * d * d * d + b[7] * d * d * d * d * d + b[8] * d * d * d * d * d * d,
                    c = c * (0 > a.lng ? -1 : 1),
                    d = d * (0 > a.lat ? -1 : 1);
                return new H(c, d)
            }
        },
        Qe: function(a, b, c, d) {
            return this.XO * Math.acos(Math.sin(c) * Math.sin(d) + Math.cos(c) * Math.cos(d) * Math.cos(b - a))
        },
        Pk: function(a) {
            return Math.PI * a / 180
        },
        V3: function(a) {
            return 180 * a / Math.PI
        },
        OD: function(a, b, c) {
            b != p && (a = Math.max(a, b));
            c != p && (a = Math.min(a, c));
            return a
        },
        KD: function(a, b, c) {
            for (; a > c;) a -= c - b;
            for (; a < b;) a += c - b;
            return a
        }
    });
    x.extend(R.prototype, {
        Gm: function(a) {
            return R.Eb(a)
        },
        mh: function(a) {
            a = R.Eb(a);
            return new Q(a.lng, a.lat)
        },
        ph: function(a) {
            return R.Fb(a)
        },
        vi: function(a) {
            a = new H(a.x, a.y);
            return R.Fb(a)
        },
        fc: function(a, b, c, d, e) {
            if (a) return a = this.Gm(a, e), b = this.Lc(b), new Q(Math.round((a.lng - c.lng) / b + d.width / 2), Math.round((c.lat - a.lat) / b + d.height / 2))
        },
        zb: function(a, b, c, d, e) {
            if (a) return b = this.Lc(b), this.ph(new H(c.lng + b * (a.x - d.width / 2), c.lat - b * (a.y - d.height / 2)), e)
        },
        Lc: function(a) {
            return Math.pow(2, 18 - a)
        }
    });

    function gb() {
        this.gj = "bj"
    }
    gb.prototype = new R;
    x.extend(gb.prototype, {
        Gm: function(a, b) {
            return this.pQ(b, R.Eb(a))
        },
        ph: function(a, b) {
            return R.Fb(this.qQ(b, a))
        },
        lngLatToPointFor3D: function(a, b) {
            var c = this,
                d = R.Eb(a);
            I.load("coordtrans", function() {
                var a = gc.MD(c.gj || "bj", d),
                    a = new Q(a.x, a.y);
                b && b(a)
            }, o)
        },
        pointToLngLatFor3D: function(a, b) {
            var c = this,
                d = new H(a.x, a.y);
            I.load("coordtrans", function() {
                var a = gc.LD(c.gj || "bj", d),
                    a = new H(a.lng, a.lat),
                    a = R.Fb(a);
                b && b(a)
            }, o)
        },
        pQ: function(a, b) {
            if (I.gb("coordtrans").Ad == I.Fj.Xp) {
                var c = gc.MD(a || "bj", b);
                return new H(c.x, c.y)
            }
            I.load("coordtrans", s());
            return new H(0, 0)
        },
        qQ: function(a, b) {
            if (I.gb("coordtrans").Ad == I.Fj.Xp) {
                var c = gc.LD(a || "bj", b);
                return new H(c.lng, c.lat)
            }
            I.load("coordtrans", s());
            return new H(0, 0)
        },
        Lc: function(a) {
            return Math.pow(2, 20 - a)
        }
    });

    function ic() {
        this.Lb = "overlay"
    }
    x.lang.sa(ic, x.lang.Ba, "Overlay");
    ic.um = function(a) {
        a *= 1;
        return !a ? 0 : -1E5 * a << 1
    };
    x.extend(ic.prototype, {
        Ce: function(a) {
            if (!this.V && Va(this.initialize) && (this.V = this.initialize(a))) this.V.style.WebkitUserSelect = "none";
            this.draw()
        },
        initialize: function() {
            aa("initialize\u65b9\u6cd5\u672a\u5b9e\u73b0")
        },
        draw: function() {
            aa("draw\u65b9\u6cd5\u672a\u5b9e\u73b0")
        },
        remove: function() {
            this.V && this.V.parentNode && this.V.parentNode.removeChild(this.V);
            this.V = p;
            this.dispatchEvent(new N("onremove"))
        },
        U: function() {
            this.V && x.D.U(this.V)
        },
        show: function() {
            this.V && x.D.show(this.V)
        },
        lh: function() {
            return !this.V || "none" == this.V.style.display || "hidden" == this.V.style.visibility ? q : o
        }
    });
    z.Te(function(a) {
        function b(a, b) {
            var c = K("div"),
                g = c.style;
            g.position = "absolute";
            g.top = g.left = g.width = g.height = "0";
            g.zIndex = b;
            a.appendChild(c);
            return c
        }
        var c = a.R;
        c.nd = a.nd = b(a.platform, 200);
        a.Td.pD = b(c.nd, 800);
        a.Td.AE = b(c.nd, 700);
        a.Td.PK = b(c.nd, 600);
        a.Td.tE = b(c.nd, 500);
        a.Td.sM = b(c.nd, 400);
        a.Td.tM = b(c.nd, 300);
        a.Td.CO = b(c.nd, 201);
        a.Td.ot = b(c.nd, 200)
    });

    function fb() {
        x.lang.Ba.call(this);
        ic.call(this);
        this.map = p;
        this.Pa = o;
        this.xb = p;
        this.VG = 0
    }
    x.lang.sa(fb, ic, "OverlayInternal");
    x.extend(fb.prototype, {
        initialize: function(a) {
            this.map = a;
            x.lang.Ba.call(this, this.ca);
            return p
        },
        lx: t("map"),
        draw: s(),
        Hj: s(),
        remove: function() {
            this.map = p;
            x.lang.Pw(this.ca);
            ic.prototype.remove.call(this)
        },
        U: function() {
            this.Pa !== q && (this.Pa = q)
        },
        show: function() {
            this.Pa !== o && (this.Pa = o)
        },
        lh: function() {
            return !this.V ? q : !!this.Pa
        },
        Na: t("V"),
        zN: function(a) {
            var a = a || {},
                b;
            for (b in a) this.z[b] = a[b]
        },
        St: ba("zIndex"),
        gi: function() {
            this.z.gi = o
        },
        RV: function() {
            this.z.gi = q
        },
        ro: ba("hg"),
        vp: function() {
            this.hg = p
        }
    });

    function jc() {
        this.map = p;
        this.ua = {};
        this.ze = []
    }
    z.Te(function(a) {
        var b = new jc;
        b.map = a;
        a.ua = b.ua;
        a.ze = b.ze;
        a.addEventListener("load", function(a) {
            b.draw(a)
        });
        a.addEventListener("moveend", function(a) {
            b.draw(a)
        });
        x.ea.la && 8 > x.ea.la || "BackCompat" === document.compatMode ? a.addEventListener("zoomend", function(a) {
            setTimeout(function() {
                b.draw(a)
            }, 20)
        }) : a.addEventListener("zoomend", function(a) {
            b.draw(a)
        });
        a.addEventListener("maptypechange", function(a) {
            b.draw(a)
        });
        a.addEventListener("addoverlay", function(a) {
            a = a.target;
            if (a instanceof fb) b.ua[a.ca] || (b.ua[a.ca] = a);
            else {
                for (var d = q, e = 0, f = b.ze.length; e < f; e++)
                    if (b.ze[e] === a) {
                        d = o;
                        break
                    }
                d || b.ze.push(a)
            }
        });
        a.addEventListener("removeoverlay", function(a) {
            a = a.target;
            if (a instanceof fb) delete b.ua[a.ca];
            else
                for (var d = 0, e = b.ze.length; d < e; d++)
                    if (b.ze[d] === a) {
                        b.ze.splice(d, 1);
                        break
                    }
        });
        a.addEventListener("clearoverlays", function() {
            this.Wc();
            for (var a in b.ua) b.ua[a].z.gi && (b.ua[a].remove(), delete b.ua[a]);
            a = 0;
            for (var d = b.ze.length; a < d; a++) b.ze[a].gi !== q && (b.ze[a].remove(), b.ze[a] = p, b.ze.splice(a, 1), a--, d--)
        });
        a.addEventListener("infowindowopen", function() {
            var a = this.xb;
            a && (x.D.U(a.xc), x.D.U(a.$b))
        });
        a.addEventListener("movestart", function() {
            this.ih() && this.ih().JI()
        });
        a.addEventListener("moveend", function() {
            this.ih() && this.ih().zI()
        })
    });
    jc.prototype.draw = function(a) {
        if (z.aq) {
            var b = z.aq.Os(this.map);
            "canvas" === b.Lb && b.canvas && b.kQ(b.canvas.getContext("2d"))
        }
        for (var c in this.ua) this.ua[c].draw(a);
        x.jc.Db(this.ze, function(a) {
            a.draw()
        });
        this.map.R.mb && this.map.R.mb.ra();
        z.aq && b.nF()
    };

    function kc(a) {
        fb.call(this);
        a = a || {};
        this.z = {
            strokeColor: a.strokeColor || "#3a6bdb",
            lc: a.strokeWeight || 5,
            qd: a.strokeOpacity || 0.65,
            strokeStyle: a.strokeStyle || "solid",
            gi: a.enableMassClear === q ? q : o,
            uk: p,
            om: p,
            Nf: a.enableEditing === o ? o : q,
            BM: 5,
            H_: q,
            ff: a.enableClicking === q ? q : o,
            mi: a.icons && 0 < a.icons.length ? a.icons : p
        };
        0 >= this.z.lc && (this.z.lc = 5);
        if (0 > this.z.qd || 1 < this.z.qd) this.z.qd = 0.65;
        if (0 > this.z.qg || 1 < this.z.qg) this.z.qg = 0.65;
        "solid" != this.z.strokeStyle && "dashed" != this.z.strokeStyle && (this.z.strokeStyle = "solid");
        this.V = p;
        this.Mu = new eb(0, 0);
        this.bf = [];
        this.mc = [];
        this.Qa = {}
    }
    x.lang.sa(kc, fb, "Graph");
    kc.gx = function(a) {
        var b = [];
        if (!a) return b;
        Xa(a) && x.jc.Db(a.split(";"), function(a) {
            a = a.split(",");
            b.push(new H(a[0], a[1]))
        });
        "[object Array]" == Object.prototype.toString.apply(a) && 0 < a.length && (b = a);
        return b
    };
    kc.KE = [0.09, 0.0050, 1.0E-4, 1.0E-5];
    x.extend(kc.prototype, {
        initialize: function(a) {
            this.map = a;
            return p
        },
        draw: s(),
        Gr: function(a) {
            this.bf.length = 0;
            this.ia = kc.gx(a).slice(0);
            this.Dh()
        },
        he: function(a) {
            this.Gr(a)
        },
        Dh: function() {
            if (this.ia) {
                var a = this;
                a.Mu = new eb;
                x.jc.Db(this.ia, function(b) {
                    a.Mu.extend(b)
                })
            }
        },
        pe: t("ia"),
        dn: function(a, b) {
            b && this.ia[a] && (this.bf.length = 0, this.ia[a] = new H(b.lng, b.lat), this.Dh())
        },
        setStrokeColor: function(a) {
            this.z.strokeColor = a
        },
        nX: function() {
            return this.z.strokeColor
        },
        Mp: function(a) {
            0 < a && (this.z.lc = a)
        },
        qL: function() {
            return this.z.lc
        },
        Kp: function(a) {
            a == j || (1 < a || 0 > a) || (this.z.qd = a)
        },
        oX: function() {
            return this.z.qd
        },
        Lt: function(a) {
            1 < a || 0 > a || (this.z.qg = a)
        },
        LW: function() {
            return this.z.qg
        },
        Lp: function(a) {
            "solid" != a && "dashed" != a || (this.z.strokeStyle = a)
        },
        pL: function() {
            return this.z.strokeStyle
        },
        setFillColor: function(a) {
            this.z.fillColor = a || ""
        },
        KW: function() {
            return this.z.fillColor
        },
        Ed: t("Mu"),
        remove: function() {
            this.map && this.map.removeEventListener("onmousemove", this.iv);
            fb.prototype.remove.call(this);
            this.bf.length = 0
        },
        Nf: function() {
            if (!(2 > this.ia.length)) {
                this.z.Nf = o;
                var a = this;
                I.load("poly", function() {
                    a.Nl()
                }, o)
            }
        },
        QV: function() {
            this.z.Nf = q;
            var a = this;
            I.load("poly", function() {
                a.kk()
            }, o)
        }
    });

    function lc(a) {
        fb.call(this);
        this.V = this.map = p;
        this.z = {
            width: 0,
            height: 0,
            ya: new L(0, 0),
            opacity: 1,
            background: "transparent",
            Ox: 1,
            eM: "#000",
            lY: "solid",
            point: p
        };
        this.zN(a);
        this.point = this.z.point
    }
    x.lang.sa(lc, fb, "Division");
    x.extend(lc.prototype, {
        Hj: function() {
            var a = this.z,
                b = this.content,
                c = ['<div class="BMap_Division" style="position:absolute;'];
            c.push("width:" + a.width + "px;display:block;");
            c.push("overflow:hidden;");
            "none" != a.borderColor && c.push("border:" + a.Ox + "px " + a.lY + " " + a.eM + ";");
            c.push("opacity:" + a.opacity + "; filter:(opacity=" + 100 * a.opacity + ")");
            c.push("background:" + a.background + ";");
            c.push('z-index:60;">');
            c.push(b);
            c.push("</div>");
            this.V = yb(this.map.Qf().AE, c.join(""))
        },
        initialize: function(a) {
            this.map = a;
            this.Hj();
            this.V && x.K(this.V, G() ? "touchstart" : "mousedown", function(a) {
                na(a)
            });
            return this.V
        },
        draw: function() {
            var a = this.map.Se(this.z.point);
            this.z.ya = new L(-Math.round(this.z.width / 2) - Math.round(this.z.Ox), -Math.round(this.z.height / 2) - Math.round(this.z.Ox));
            this.V.style.left = a.x + this.z.ya.width + "px";
            this.V.style.top = a.y + this.z.ya.height + "px"
        },
        ha: function() {
            return this.z.point
        },
        y0: function() {
            return this.map.fc(this.ha())
        },
        ra: function(a) {
            this.z.point = a;
            this.draw()
        },
        AZ: function(a, b) {
            this.z.width = Math.round(a);
            this.z.height = Math.round(b);
            this.V && (this.V.style.width = this.z.width + "px", this.V.style.height = this.z.height + "px", this.draw())
        }
    });

    function mc(a, b, c) {
        a && b && (this.imageUrl = a, this.size = b, a = new L(Math.floor(b.width / 2), Math.floor(b.height / 2)), c = c || {}, a = c.anchor || a, b = c.imageOffset || new L(0, 0), this.imageSize = c.imageSize, this.anchor = a, this.imageOffset = b, this.infoWindowAnchor = c.infoWindowAnchor || this.anchor, this.printImageUrl = c.printImageUrl || "")
    }
    x.extend(mc.prototype, {
        AN: function(a) {
            a && (this.imageUrl = a)
        },
        QZ: function(a) {
            a && (this.printImageUrl = a)
        },
        Jd: function(a) {
            a && (this.size = new L(a.width, a.height))
        },
        pc: function(a) {
            a && (this.anchor = new L(a.width, a.height))
        },
        Mt: function(a) {
            a && (this.imageOffset = new L(a.width, a.height))
        },
        HZ: function(a) {
            a && (this.infoWindowAnchor = new L(a.width, a.height))
        },
        EZ: function(a) {
            a && (this.imageSize = new L(a.width, a.height))
        },
        toString: ca("Icon")
    });

    function nc(a, b) {
        if (a) {
            b = b || {};
            this.style = {
                anchor: b.anchor || new L(0, 0),
                fillColor: b.fillColor || "#000",
                qg: b.fillOpacity || 0,
                scale: b.scale || 1,
                rotation: b.rotation || 0,
                strokeColor: b.strokeColor || "#000",
                qd: b.strokeOpacity || 1,
                lc: b.strokeWeight
            };
            this.Lb = "number" === typeof a ? a : "UserDefined";
            this.Ii = this.style.anchor;
            this.lr = new L(0, 0);
            this.anchor = p;
            this.hB = a;
            var c = this;
            I.load("symbol", function() {
                c.Gn()
            }, o)
        }
    }
    x.extend(nc.prototype, {
        setPath: ba("hB"),
        setAnchor: function(a) {
            this.Ii = this.style.anchor = a
        },
        setRotation: function(a) {
            this.style.rotation = a
        },
        setScale: function(a) {
            this.style.scale = a
        },
        setStrokeWeight: function(a) {
            this.style.lc = a
        },
        setStrokeColor: function(a) {
            a = x.as.oC(a, this.style.qd);
            this.style.strokeColor = a
        },
        setStrokeOpacity: function(a) {
            this.style.qd = a
        },
        setFillOpacity: function(a) {
            this.style.qg = a
        },
        setFillColor: function(a) {
            this.style.fillColor = a
        }
    });

    function oc(a, b, c, d) {
        a && (this.Bv = {}, this.OK = d ? !!d : q, this.Uc = [], this.h_ = a instanceof nc ? a : p, this.sI = b === j ? o : !!(b.indexOf("%") + 1), this.Zj = isNaN(parseFloat(b)) ? 1 : this.sI ? parseFloat(b) / 100 : parseFloat(b), this.tI = !!(c.indexOf("%") + 1), this.repeat = c != j ? this.tI ? parseFloat(c) / 100 : parseFloat(c) : 0)
    };

    function pc(a, b) {
        x.lang.Ba.call(this);
        this.content = a;
        this.map = p;
        b = b || {};
        this.z = {
            width: b.width || 0,
            height: b.height || 0,
            maxWidth: b.maxWidth || 730,
            ya: b.offset || new L(0, 0),
            title: b.title || "",
            BE: b.maxContent || "",
            dh: b.enableMaximize || q,
            Ds: b.enableAutoPan === q ? q : o,
            bD: b.enableCloseOnClick === q ? q : o,
            margin: b.margin || [10, 10, 40, 10],
            jC: b.collisions || [
                [10, 10],
                [10, 10],
                [10, 10],
                [10, 10]
            ],
            KX: q,
            GY: b.onClosing || ca(o),
            FK: q,
            gD: b.enableParano === o ? o : q,
            message: b.message,
            iD: b.enableSearchTool === o ? o : q,
            Ax: b.headerContent || "",
            cD: b.enableContentScroll || q
        };
        if (0 != this.z.width && (220 > this.z.width && (this.z.width = 220), 730 < this.z.width)) this.z.width = 730;
        if (0 != this.z.height && (60 > this.z.height && (this.z.height = 60), 650 < this.z.height)) this.z.height = 650;
        if (0 != this.z.maxWidth && (220 > this.z.maxWidth && (this.z.maxWidth = 220), 730 < this.z.maxWidth)) this.z.maxWidth = 730;
        this.be = q;
        this.Di = F.oa;
        this.$a = p;
        var c = this;
        I.load("infowindow", function() {
            c.vb()
        })
    }
    x.lang.sa(pc, x.lang.Ba, "InfoWindow");
    x.extend(pc.prototype, {
        setWidth: function(a) {
            !a && 0 != a || (isNaN(a) || 0 > a) || (0 != a && (220 > a && (a = 220), 730 < a && (a = 730)), this.z.width = a)
        },
        setHeight: function(a) {
            !a && 0 != a || (isNaN(a) || 0 > a) || (0 != a && (60 > a && (a = 60), 650 < a && (a = 650)), this.z.height = a)
        },
        DN: function(a) {
            !a && 0 != a || (isNaN(a) || 0 > a) || (0 != a && (220 > a && (a = 220), 730 < a && (a = 730)), this.z.maxWidth = a)
        },
        Bc: function(a) {
            this.z.title = a
        },
        getTitle: function() {
            return this.z.title
        },
        ad: ba("content"),
        sk: t("content"),
        Ot: function(a) {
            this.z.BE = a + ""
        },
        ge: s(),
        Ds: function() {
            this.z.Ds = o
        },
        disableAutoPan: function() {
            this.z.Ds = q
        },
        enableCloseOnClick: function() {
            this.z.bD = o
        },
        disableCloseOnClick: function() {
            this.z.bD = q
        },
        dh: function() {
            this.z.dh = o
        },
        Sw: function() {
            this.z.dh = q
        },
        show: function() {
            this.Pa = o
        },
        U: function() {
            this.Pa = q
        },
        close: function() {
            this.U()
        },
        Sx: function() {
            this.be = o
        },
        restore: function() {
            this.be = q
        },
        lh: function() {
            return this.Va()
        },
        Va: ca(q),
        ha: function() {
            if (this.$a && this.$a.ha) return this.$a.ha()
        },
        Pf: function() {
            return this.z.ya
        }
    });
    Ka.prototype.Mb = function(a, b) {
        if (a instanceof pc && b instanceof H) {
            var c = this.R;
            c.Im ? c.Im.ra(b) : (c.Im = new T(b, {
                icon: new mc(F.oa + "blank.gif", {
                    width: 1,
                    height: 1
                }),
                offset: new L(0, 0),
                clickable: q
            }), c.Im.nR = 1);
            this.Ia(c.Im);
            c.Im.Mb(a)
        }
    };
    Ka.prototype.Wc = function() {
        var a = this.R.mb || this.R.hl;
        a && a.$a && a.$a.Wc()
    };
    fb.prototype.Mb = function(a) {
        this.map && (this.map.Wc(), a.Pa = o, this.map.R.hl = a, a.$a = this, x.lang.Ba.call(a, a.ca))
    };
    fb.prototype.Wc = function() {
        this.map && this.map.R.hl && (this.map.R.hl.Pa = q, x.lang.Pw(this.map.R.hl.ca), this.map.R.hl = p)
    };

    function qc(a, b) {
        fb.call(this);
        this.content = a;
        this.V = this.map = p;
        b = b || {};
        this.z = {
            width: 0,
            ya: b.offset || new L(0, 0),
            Pp: {
                backgroundColor: "#fff",
                border: "1px solid #f00",
                padding: "1px",
                whiteSpace: "nowrap",
                font: "12px " + F.fontFamily,
                zIndex: "80",
                MozUserSelect: "none"
            },
            position: b.position || p,
            gi: b.enableMassClear === q ? q : o,
            ff: o
        };
        0 > this.z.width && (this.z.width = 0);
        Fb(b.enableClicking) && (this.z.ff = b.enableClicking);
        this.point = this.z.position;
        var c = this;
        I.load("marker", function() {
            c.vb()
        })
    }
    x.lang.sa(qc, fb, "Label");
    x.extend(qc.prototype, {
        ha: function() {
            return this.qv ? this.qv.ha() : this.point
        },
        ra: function(a) {
            a instanceof H && !this.mx() && (this.point = this.z.position = new H(a.lng, a.lat))
        },
        ad: ba("content"),
        mF: function(a) {
            0 <= a && 1 >= a && (this.z.opacity = a)
        },
        Ue: function(a) {
            a instanceof L && (this.z.ya = new L(a.width, a.height))
        },
        Pf: function() {
            return this.z.ya
        },
        Kd: function(a) {
            a = a || {};
            this.z.Pp = x.extend(this.z.Pp, a)
        },
        xi: function(a) {
            return this.Kd(a)
        },
        Bc: function(a) {
            this.z.title = a || ""
        },
        getTitle: function() {
            return this.z.title
        },
        CN: function(a) {
            this.point = (this.qv = a) ? this.z.position = a.ha() : this.z.position = p
        },
        mx: function() {
            return this.qv || p
        },
        sk: t("content")
    });

    function rc(a, b) {
        if (0 !== arguments.length) {
            fb.apply(this, arguments);
            b = b || {};
            this.z = {
                fb: a,
                opacity: b.opacity || 1,
                Am: b.Am || "",
                rs: b.displayOnMinLevel || 1,
                gi: b.enableMassClear === q ? q : o,
                qs: b.displayOnMaxLevel || 19,
                b_: b.stretch || q
            };
            var c = this;
            I.load("groundoverlay", function() {
                c.vb()
            })
        }
    }
    x.lang.sa(rc, fb, "GroundOverlay");
    x.extend(rc.prototype, {
        setBounds: function(a) {
            this.z.fb = a
        },
        getBounds: function() {
            return this.z.fb
        },
        setOpacity: function(a) {
            this.z.opacity = a
        },
        getOpacity: function() {
            return this.z.opacity
        },
        setImageURL: function(a) {
            this.z.Am = a
        },
        getImageURL: function() {
            return this.z.Am
        },
        setDisplayOnMinLevel: function(a) {
            this.z.rs = a
        },
        getDisplayOnMinLevel: function() {
            return this.z.rs
        },
        setDisplayOnMaxLevel: function(a) {
            this.z.qs = a
        },
        getDisplayOnMaxLevel: function() {
            return this.z.qs
        }
    });
    var sc = 3,
        tc = 4;

    function uc() {
        var a = document.createElement("canvas");
        return !(!a.getContext || !a.getContext("2d"))
    }

    function vc(a, b) {
        var c = this;
        uc() && (a === j && aa(Error("\u6ca1\u6709\u4f20\u5165points\u6570\u636e")), "[object Array]" !== Object.prototype.toString.call(a) && aa(Error("points\u6570\u636e\u4e0d\u662f\u6570\u7ec4")), b = b || {}, fb.apply(c, arguments), c.da = {
            ia: a
        }, c.z = {
            shape: b.shape || sc,
            size: b.size || tc,
            color: b.color || "#fa937e",
            gi: o
        }, this.eB = [], this.le = [], I.load("pointcollection", function() {
            for (var a = 0, b; b = c.eB[a]; a++) c[b.method].apply(c, b.arguments);
            for (a = 0; b = c.le[a]; a++) c[b.method].apply(c, b.arguments)
        }))
    }
    x.lang.sa(vc, fb, "PointCollection");
    x.extend(vc.prototype, {
        initialize: function(a) {
            this.eB && this.eB.push({
                method: "initialize",
                arguments: arguments
            })
        },
        setPoints: function(a) {
            this.le && this.le.push({
                method: "setPoints",
                arguments: arguments
            })
        },
        setStyles: function(a) {
            this.le && this.le.push({
                method: "setStyles",
                arguments: arguments
            })
        },
        clear: function() {
            this.le && this.le.push({
                method: "clear",
                arguments: arguments
            })
        },
        remove: function() {
            this.le && this.le.push({
                method: "remove",
                arguments: arguments
            })
        }
    });
    var wc = new mc(F.oa + "marker_red_sprite.png", new L(19, 25), {
            anchor: new L(10, 25),
            infoWindowAnchor: new L(10, 0)
        }),
        xc = new mc(F.oa + "marker_red_sprite.png", new L(20, 11), {
            anchor: new L(6, 11),
            imageOffset: new L(-19, -13)
        });

    function T(a, b) {
        fb.call(this);
        b = b || {};
        this.point = a;
        this.qq = this.map = p;
        this.z = {
            ya: b.offset || new L(0, 0),
            vj: b.icon || wc,
            Jk: xc,
            title: b.title || "",
            label: p,
            KJ: b.baseZIndex || 0,
            ff: o,
            q4: q,
            pE: q,
            gi: b.enableMassClear === q ? q : o,
            bc: q,
            iN: b.raiseOnDrag === o ? o : q,
            pN: q,
            Cd: b.draggingCursor || F.Cd,
            rotation: b.rotation || 0
        };
        b.icon && !b.shadow && (this.z.Jk = p);
        b.enableDragging && (this.z.bc = b.enableDragging);
        Fb(b.enableClicking) && (this.z.ff = b.enableClicking);
        var c = this;
        I.load("marker", function() {
            c.vb()
        })
    }
    T.Fu = ic.um(-90) + 1E6;
    T.cG = T.Fu + 1E6;
    x.lang.sa(T, fb, "Marker");
    x.extend(T.prototype, {
        Tb: function(a) {
            if (a instanceof mc || a instanceof nc) this.z.vj = a
        },
        To: function() {
            return this.z.vj
        },
        yy: function(a) {
            a instanceof mc && (this.z.Jk = a)
        },
        getShadow: function() {
            return this.z.Jk
        },
        an: function(a) {
            this.z.label = a || p
        },
        HD: function() {
            return this.z.label
        },
        bc: function() {
            this.z.bc = o
        },
        HC: function() {
            this.z.bc = q
        },
        ha: t("point"),
        ra: function(a) {
            a instanceof H && (this.point = new H(a.lng, a.lat))
        },
        yi: function(a, b) {
            this.z.pE = !!a;
            a && (this.yG = b || 0)
        },
        Bc: function(a) {
            this.z.title = a + ""
        },
        getTitle: function() {
            return this.z.title
        },
        Ue: function(a) {
            a instanceof L && (this.z.ya = a)
        },
        Pf: function() {
            return this.z.ya
        },
        $m: ba("qq"),
        Jp: function(a) {
            this.z.rotation = a
        },
        nL: function() {
            return this.z.rotation
        }
    });

    function yc(a, b) {
        kc.call(this, b);
        b = b || {};
        this.z.qg = b.fillOpacity ? b.fillOpacity : 0.65;
        this.z.fillColor = "" == b.fillColor ? "" : b.fillColor ? b.fillColor : "#fff";
        this.he(a);
        var c = this;
        I.load("poly", function() {
            c.vb()
        })
    }
    x.lang.sa(yc, kc, "Polygon");
    x.extend(yc.prototype, {
        he: function(a, b) {
            this.oo = kc.gx(a).slice(0);
            var c = kc.gx(a).slice(0);
            1 < c.length && c.push(new H(c[0].lng, c[0].lat));
            kc.prototype.he.call(this, c, b)
        },
        dn: function(a, b) {
            this.oo[a] && (this.oo[a] = new H(b.lng, b.lat), this.ia[a] = new H(b.lng, b.lat), 0 == a && !this.ia[0].lb(this.ia[this.ia.length - 1]) && (this.ia[this.ia.length - 1] = new H(b.lng, b.lat)), this.Dh())
        },
        pe: function() {
            var a = this.oo;
            0 == a.length && (a = this.ia);
            return a
        }
    });

    function zc(a, b) {
        kc.call(this, b);
        this.Gr(a);
        var c = this;
        I.load("poly", function() {
            c.vb()
        })
    }
    x.lang.sa(zc, kc, "Polyline");

    function Ac(a, b, c) {
        this.point = a;
        this.wa = Math.abs(b);
        yc.call(this, [], c)
    }
    Ac.KE = [0.01, 1.0E-4, 1.0E-5, 4.0E-6];
    x.lang.sa(Ac, yc, "Circle");
    x.extend(Ac.prototype, {
        initialize: function(a) {
            this.map = a;
            this.ia = this.ev(this.point, this.wa);
            this.Dh();
            return p
        },
        Ka: t("point"),
        Vf: function(a) {
            a && (this.point = a)
        },
        lL: t("wa"),
        qf: function(a) {
            this.wa = Math.abs(a)
        },
        ev: function(a, b) {
            if (!a || !b || !this.map) return [];
            for (var c = [], d = b / 6378800, e = Math.PI / 180 * a.lat, f = Math.PI / 180 * a.lng, g = 0; 360 > g; g += 9) {
                var i = Math.PI / 180 * g,
                    k = Math.asin(Math.sin(e) * Math.cos(d) + Math.cos(e) * Math.sin(d) * Math.cos(i)),
                    i = new H(((f - Math.atan2(Math.sin(i) * Math.sin(d) * Math.cos(e), Math.cos(d) - Math.sin(e) * Math.sin(k)) + Math.PI) % (2 * Math.PI) - Math.PI) * (180 / Math.PI), k * (180 / Math.PI));
                c.push(i)
            }
            d = c[0];
            c.push(new H(d.lng, d.lat));
            return c
        }
    });
    var Bc = {};

    function Cc(a) {
        this.map = a;
        this.Hm = [];
        this.Wf = [];
        this.Eg = [];
        this.ZU = 300;
        this.VE = 0;
        this.wg = {};
        this.fj = {};
        this.rh = 0;
        this.jE = o;
        this.lK = {};
        this.Yn = this.Jn(1);
        this.kd = this.Jn(2);
        this.rl = this.Jn(3);
        a.platform.appendChild(this.Yn);
        a.platform.appendChild(this.kd);
        a.platform.appendChild(this.rl)
    }
    z.Te(function(a) {
        var b = new Cc(a);
        b.pa();
        a.tb = b
    });
    x.extend(Cc.prototype, {
        pa: function() {
            var a = this,
                b = a.map;
            b.addEventListener("loadcode", function() {
                a.Px()
            });
            b.addEventListener("addtilelayer", function(b) {
                a.Yg(b)
            });
            b.addEventListener("removetilelayer", function(b) {
                a.yh(b)
            });
            b.addEventListener("setmaptype", function(b) {
                a.Bg(b)
            });
            b.addEventListener("zoomstartcode", function(b) {
                a.Kc(b)
            });
            b.addEventListener("setcustomstyles", function(b) {
                a.Nt(b.target);
                a.Tf(o)
            })
        },
        Px: function() {
            var a = this;
            if (x.ea.la) try {
                document.execCommand("BackgroundImageCache", q, o)
            } catch (b) {}
            this.loaded || a.Fx();
            a.Tf();
            this.loaded || (this.loaded = o, I.load("tile", function() {
                a.HP()
            }))
        },
        Fx: function() {
            for (var a = this.map.va().gr, b = 0; b < a.length; b++) {
                var c = new Dc;
                x.extend(c, a[b]);
                this.Hm.push(c);
                c.pa(this.map, this.Yn)
            }
            this.Nt()
        },
        Jn: function(a) {
            var b = K("div");
            b.style.position = "absolute";
            b.style.overflow = "visible";
            b.style.left = b.style.top = "0";
            b.style.zIndex = a;
            return b
        },
        vf: function() {
            this.rh--;
            var a = this;
            this.jE && (this.map.dispatchEvent(new N("onfirsttileloaded")), this.jE = q);
            0 == this.rh && (this.Mi && (clearTimeout(this.Mi), this.Mi = p), this.Mi = setTimeout(function() {
                if (a.rh == 0) {
                    a.map.dispatchEvent(new N("ontilesloaded"));
                    a.jE = o
                }
                a.Mi = p
            }, 80))
        },
        SD: function(a, b) {
            return "TILE-" + b.ca + "-" + a[0] + "-" + a[1] + "-" + a[2]
        },
        Dx: function(a) {
            var b = a.Gb;
            b && xb(b) && b.parentNode.removeChild(b);
            delete this.wg[a.name];
            a.loaded || (Ec(a), a.Gb = p, a.Km = p)
        },
        tm: function(a, b, c) {
            var d = this.map,
                e = d.va(),
                f = d.Ga,
                g = d.wc,
                i = e.Lc(f),
                k = this.aL(),
                l = k[0],
                m = k[1],
                n = k[2],
                u = k[3],
                v = k[4],
                c = "undefined" != typeof c ? c : 0,
                e = e.k.Ob,
                k = d.ca.replace(/^TANGRAM_/, "");
            for (this.Qc ? this.Qc.length = 0 : this.Qc = []; l < n; l++)
                for (var w = m; w < u; w++) {
                    var y = l,
                        B = w;
                    this.Qc.push([y, B]);
                    y = k + "_" + b + "_" + y + "_" + B + "_" + f;
                    this.lK[y] = y
                }
            this.Qc.sort(function(a) {
                return function(b, c) {
                    return 0.4 * Math.abs(b[0] - a[0]) + 0.6 * Math.abs(b[1] - a[1]) - (0.4 * Math.abs(c[0] - a[0]) + 0.6 * Math.abs(c[1] - a[1]))
                }
            }([v[0] - 1, v[1] - 1]));
            g = [Math.round(-g.lng / i), Math.round(g.lat / i)];
            l = -d.offsetY + d.height / 2;
            a.style.left = -d.offsetX + d.width / 2 + "px";
            a.style.top = l + "px";
            this.Le ? this.Le.length = 0 : this.Le = [];
            l = 0;
            for (d = a.childNodes.length; l < d; l++) w = a.childNodes[l], w.br = q, this.Le.push(w);
            if (l = this.Nm)
                for (var A in l) delete l[A];
            else this.Nm = {};
            this.Me ? this.Me.length = 0 : this.Me = [];
            l = 0;
            for (d = this.Qc.length; l < d; l++) {
                A = this.Qc[l][0];
                i = this.Qc[l][1];
                w = 0;
                for (m = this.Le.length; w < m; w++)
                    if (n = this.Le[w], n.id == k + "_" + b + "_" + A + "_" + i + "_" + f) {
                        n.br = o;
                        this.Nm[n.id] = n;
                        break
                    }
            }
            l = 0;
            for (d = this.Le.length; l < d; l++) n = this.Le[l], n.br || this.Me.push(n);
            this.kn = [];
            w = (e + c) * this.map.M.devicePixelRatio;
            l = 0;
            for (d = this.Qc.length; l < d; l++) A = this.Qc[l][0], i = this.Qc[l][1], u = A * e + g[0] - c / 2, v = (-1 - i) * e + g[1] - c / 2, y = k + "_" + b + "_" + A + "_" + i + "_" + f, m = this.Nm[y], n = p, m ? (n = m.style, n.left = u + "px", n.top = v + "px", m.Ye || this.kn.push([A, i, m])) : (0 < this.Me.length ? (m = this.Me.shift(), m.getContext("2d").clearRect(-c / 2, -c / 2, w, w), n = m.style) : (m = document.createElement("canvas"), n = m.style, n.position = "absolute", n.width = e + c + "px", n.height = e + c + "px", this.Kx() && (n.WebkitTransform = "scale(1.001)"), m.setAttribute("width", w), m.setAttribute("height", w), a.appendChild(m)), m.id = y, n.left = u + "px", n.top = v + "px", -1 < y.indexOf("bg") && (u = "#F3F1EC", this.map.M.wo && (u = this.map.M.wo), n.background = u ? u : ""), this.kn.push([A, i, m])), m.style.visibility = "";
            l = 0;
            for (d = this.Me.length; l < d; l++) this.Me[l].style.visibility = "hidden";
            return this.kn
        },
        Kx: function() {
            return /M040/i.test(navigator.userAgent)
        },
        aL: function() {
            var a = this.map,
                b = a.va(),
                c = b.XD(a.Ga),
                d = a.wc,
                e = Math.ceil(d.lng / c),
                f = Math.ceil(d.lat / c),
                b = b.k.Ob,
                c = [e, f, (d.lng - e * c) / c * b, (d.lat - f * c) / c * b];
            return [c[0] - Math.ceil((a.width / 2 - c[2]) / b), c[1] - Math.ceil((a.height / 2 - c[3]) / b), c[0] + Math.ceil((a.width / 2 + c[2]) / b), c[1] + Math.ceil((a.height / 2 + c[3]) / b), c]
        },
        XZ: function(a, b, c, d) {
            var e = this;
            e.e1 = b;
            var f = this.map.va(),
                g = e.SD(a, c),
                i = f.k.Ob,
                b = [a[0] * i + b[0], (-1 - a[1]) * i + b[1]],
                k = this.wg[g];
            k && k.Gb ? (vb(k.Gb, b), d && (d = new Q(a[0], a[1]), f = this.map.M.te ? this.map.M.te.style : "normal", d = c.getTilesUrl(d, a[2], f), k.loaded = q, Fc(k, d)), k.loaded ? this.vf() : Gc(k, function() {
                e.vf()
            })) : (k = this.fj[g]) && k.Gb ? (c.Pb.insertBefore(k.Gb, c.Pb.lastChild), this.wg[g] = k, vb(k.Gb, b), d && (d = new Q(a[0], a[1]), f = this.map.M.te ? this.map.M.te.style : "normal", d = c.getTilesUrl(d, a[2], f), k.loaded = q, Fc(k, d)), k.loaded ? this.vf() : Gc(k, function() {
                e.vf()
            })) : (k = i * Math.pow(2, f.mm() - a[2]), new H(a[0] * k, a[1] * k), d = new Q(a[0], a[1]), f = this.map.M.te ? this.map.M.te.style : "normal", d = c.getTilesUrl(d, a[2], f), k = new Hc(this, d, b, a, c), Gc(k, function() {
                e.vf()
            }), k.Xn(), this.wg[g] = k)
        },
        vf: function() {
            this.rh--;
            var a = this;
            0 == this.rh && (this.Mi && (clearTimeout(this.Mi), this.Mi = p), this.Mi = setTimeout(function() {
                if (a.rh == 0) {
                    a.map.dispatchEvent(new N("ontilesloaded"));
                    if (ua) {
                        if (qa && ra && sa) {
                            var b = $a(),
                                c = a.map.wb();
                            setTimeout(function() {
                                Oa(5030, {
                                    load_script_time: ra - qa,
                                    load_tiles_time: b - sa,
                                    map_width: c.width,
                                    map_height: c.height,
                                    map_size: c.width * c.height
                                })
                            }, 1E4);
                            va.oc("img_fisrt_loaded");
                            va.oc("map_width", c.width);
                            va.oc("map_height", c.height);
                            va.oc("map_size", c.width * c.height);
                            va.Um();
                            z.Ij("cus.fire", "time", {
                                z_imgfirstloaded: b - sa
                            })
                        }
                        ua = q
                    }
                }
                a.Mi = p
            }, 80))
        },
        SD: function(a, b) {
            return this.map.va() === Na ? "TILE-" + b.ca + "-" + this.map.Bw + "-" + a[0] + "-" + a[1] + "-" + a[2] : "TILE-" + b.ca + "-" + a[0] + "-" + a[1] + "-" + a[2]
        },
        Dx: function(a) {
            var b = a.Gb;
            b && (Ic(b), xb(b) && b.parentNode.removeChild(b));
            delete this.wg[a.name];
            a.loaded || (Ic(b), Ec(a), a.Gb = p, a.Km = p)
        },
        Tf: function(a) {
            var b = this;
            if (b.map.va() == Na) I.load("coordtrans", function() {
                b.map.Vb || (b.map.Vb = Na.rk(b.map.$g), b.map.Bw = Na.ZK(b.map.Vb));
                b.$H()
            }, o);
            else {
                if (a && a)
                    for (var c in this.fj) delete this.fj[c];
                b.$H(a)
            }
        },
        $H: function(a) {
            for (var b = this.Hm.concat(this.Wf), c = b.length, d = 0; d < c; d++) {
                var e = b[d];
                if (e.dc && l.Ga < e.dc) break;
                if (e.vw) {
                    var f = this.Pb = e.Pb;
                    if (a) {
                        var g = f;
                        if (g && g.childNodes)
                            for (var i = g.childNodes.length, k = i - 1; 0 <= k; k--) i = g.childNodes[k], g.removeChild(i), i = p
                    }
                    if (this.map.Ub()) {
                        this.kd.style.display = "block";
                        f.style.display = "none";
                        this.map.dispatchEvent(new N("vectorchanged"), {
                            isvector: o
                        });
                        continue
                    } else f.style.display = "block", this.kd.style.display = "none", this.map.dispatchEvent(new N("vectorchanged"), {
                        isvector: q
                    })
                }
                if (!e.QH && !(e.jp && !this.map.Ub() || e.XL && this.map.Ub())) {
                    var l = this.map,
                        m = l.va(),
                        f = m.Zo(),
                        i = l.Ga,
                        n = l.wc;
                    m == Na && n.lb(new H(0, 0)) && (n = l.wc = f.Gm(l.ef, l.Vb));
                    var u = m.Lc(i),
                        i = m.XD(i),
                        f = Math.ceil(n.lng / i),
                        g = Math.ceil(n.lat / i),
                        v = m.k.Ob,
                        i = [f, g, (n.lng - f * i) / i * v, (n.lat - g * i) / i * v],
                        k = i[0] - Math.ceil((l.width / 2 - i[2]) / v),
                        f = i[1] - Math.ceil((l.height / 2 - i[3]) / v),
                        g = i[0] + Math.ceil((l.width / 2 + i[2]) / v),
                        w = 0;
                    m === Na && 15 == l.fa() && (w = 1);
                    m = i[1] + Math.ceil((l.height / 2 + i[3]) / v) + w;
                    this.FJ = new H(n.lng, n.lat);
                    var y = this.wg,
                        v = -this.FJ.lng / u,
                        w = this.FJ.lat / u,
                        u = [Math.ceil(v), Math.ceil(w)],
                        n = l.fa(),
                        B;
                    for (B in y) {
                        var A = y[B],
                            D = A.info;
                        (D[2] != n || D[2] == n && (k > D[0] || g <= D[0] || f > D[1] || m <= D[1])) && this.Dx(A)
                    }
                    y = -l.offsetX + l.width / 2;
                    A = -l.offsetY + l.height / 2;
                    e.Pb && (e.Pb.style.left = Math.ceil(v + y) - u[0] + "px", e.Pb.style.top = Math.ceil(w + A) - u[1] + "px", e.Pb.style.WebkitTransform = "translate3d(0,0,0)");
                    v = [];
                    for (l.JB = []; k < g; k++)
                        for (w = f; w < m; w++) v.push([k, w]), l.JB.push({
                            x: k,
                            y: w
                        });
                    v.sort(function(a) {
                        return function(b, c) {
                            return 0.4 * Math.abs(b[0] - a[0]) + 0.6 * Math.abs(b[1] - a[1]) - (0.4 * Math.abs(c[0] - a[0]) + 0.6 * Math.abs(c[1] - a[1]))
                        }
                    }([i[0] - 1, i[1] - 1]));
                    i = v.length;
                    this.rh += i;
                    for (k = 0; k < i; k++) this.XZ([v[k][0], v[k][1], n], u, e, a)
                }
            }
        },
        Yg: function(a) {
            var b = this,
                c = a.target,
                a = b.map.Ub();
            if (c instanceof bb) a && !c.Bm && (c.pa(this.map, this.kd), c.Bm = o);
            else if (c.Xf && this.map.Yg(c.Xf), c.jp) {
                for (a = 0; a < b.Eg.length; a++)
                    if (b.Eg[a] == c) return;
                I.load("vector", function() {
                    c.pa(b.map, b.kd);
                    b.Eg.push(c)
                }, o)
            } else {
                for (a = 0; a < b.Wf.length; a++)
                    if (b.Wf[a] == c) return;
                c.pa(this.map, this.rl);
                b.Wf.push(c)
            }
        },
        yh: function(a) {
            var a = a.target,
                b = this.map.Ub();
            if (a instanceof bb) b && a.Bm && (a.remove(), a.Bm = q);
            else {
                a.Xf && this.map.yh(a.Xf);
                if (a.jp)
                    for (var b = 0, c = this.Eg.length; b < c; b++) a == this.Eg[b] && this.Eg.splice(b, 1);
                else {
                    b = 0;
                    for (c = this.Wf.length; b < c; b++) a == this.Wf[b] && this.Wf.splice(b, 1)
                }
                a.remove()
            }
        },
        Bg: function() {
            for (var a = this.Hm, b = 0, c = a.length; b < c; b++) a[b].remove();
            delete this.Pb;
            this.Hm = [];
            this.fj = this.wg = {};
            this.Fx();
            this.Tf()
        },
        Kc: function() {
            var a = this;
            a.sd && x.D.U(a.sd);
            setTimeout(function() {
                a.Tf();
                a.map.dispatchEvent(new N("onzoomend"))
            }, 10)
        },
        f4: s(),
        Nt: function(a) {
            var b = this.map.va();
            if (!this.map.Ub() && (a ? this.map.M.e_ = a : a = this.map.M.e_, a))
                for (var c = p, c = "2" == z.ou ? [z.url.proto + z.url.domain.main_domain_cdn.other[0] + "/"] : [z.url.proto + z.url.domain.main_domain_cdn.baidu[0] + "/", z.url.proto + z.url.domain.main_domain_cdn.baidu[1] + "/", z.url.proto + z.url.domain.main_domain_cdn.baidu[2] + "/"], d = 0, e; e = this.Hm[d]; d++)
                    if (e.SZ == o) {
                        b.k.Yb = 18;
                        e.getTilesUrl = function(b, d) {
                            var e = b.x,
                                k = b.y,
                                l = "customimage/tile?&x=" + e + "&y=" + k + "&z=" + d + "&udt=20150601",    
                                l = a.styleStr ? l + ("&styles=" + encodeURIComponent(a.styleStr)) : l + ("&customid=" + a.style);
                           
                           return c[Math.abs(e + k) % c.length] + l
                        };
                        break
                    }
        }
    });

    function Hc(a, b, c, d, e) {
        this.Km = a;
        this.position = c;
        this.Qu = [];
        this.name = a.SD(d, e);
        this.info = d;
        this.cJ = e.lt();
        d = K("img");
        wb(d);
        d.RK = q;
        var f = d.style,
            a = a.map.va();
        f.position = "absolute";
        f.border = "none";
        f.width = a.k.Ob + "px";
        f.height = a.k.Ob + "px";
        f.left = c[0] + "px";
        f.top = c[1] + "px";
        f.maxWidth = "none";
        this.Gb = d;
        this.src = b;
        Jc && (this.Gb.style.opacity = 0);
        var g = this;
        this.Gb.onload = function() {
            z.nY.sQ();
            g.loaded = o;
            if (g.Km) {
                var a = g.Km,
                    b = a.fj;
                if (!b[g.name]) {
                    a.VE++;
                    b[g.name] = g
                }
                if (g.Gb && !xb(g.Gb) && e.Pb) {
                    e.Pb.appendChild(g.Gb);
                    if (x.ea.la <= 6 && x.ea.la > 0 && g.cJ) g.Gb.style.cssText = g.Gb.style.cssText + (';filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src="' + g.src + '",sizingMethod=scale);')
                }
                var c = a.VE - a.ZU,
                    d;
                for (d in b) {
                    if (c <= 0) break;
                    if (!a.wg[d]) {
                        b[d].Km = p;
                        var f = b[d].Gb;
                        if (f && f.parentNode) {
                            f.parentNode.removeChild(f);
                            Ic(f)
                        }
                        f = p;
                        b[d].Gb = p;
                        delete b[d];
                        a.VE--;
                        c--
                    }
                }
                Jc && new rb({
                    Gc: 20,
                    duration: 200,
                    ta: function(a) {
                        if (g.Gb && g.Gb.style) g.Gb.style.opacity = a * 1
                    },
                    finish: function() {
                        g.Gb && g.Gb.style && delete g.Gb.style.opacity
                    }
                });
                Ec(g)
            }
        };
        this.Gb.onerror = function() {
            Ec(g);
            if (g.Km) {
                var a = g.Km.map.va();
                if (a.k.jD) {
                    g.error = o;
                    g.Gb.src = a.k.jD;
                    g.Gb && !xb(g.Gb) && e.Pb.appendChild(g.Gb)
                }
            }
        };
        d = p
    }

    function Gc(a, b) {
        a.Qu.push(b)
    }
    Hc.prototype.Xn = function() {
        this.Gb.src = 0 < x.ea.la && 6 >= x.ea.la && this.cJ ? F.oa + "blank.gif" : "" !== this.src && this.Gb.src == this.src ? this.src + "&t = " + Date.now() : this.src
    };

    function Ec(a) {
        for (var b = 0; b < a.Qu.length; b++) a.Qu[b]();
        a.Qu.length = 0
    }

    function Ic(a) {
        if (a) {
            a.onload = a.onerror = p;
            var b = a.attributes,
                c, d, e;
            if (b) {
                d = b.length;
                for (c = 0; c < d; c += 1) e = b[c].name, Va(a[e]) && (a[e] = p)
            }
            if (b = a.children) {
                d = b.length;
                for (c = 0; c < d; c += 1) Ic(a.children[c])
            }
        }
    }

    function Fc(a, b) {
        a.src = b;
        a.Xn()
    }
    var Jc = !x.ea.la || 8 < x.ea.la;

    function Dc(a) {
        this.th = a || {};
        this.sV = this.th.copyright || p;
        this.D_ = this.th.transparentPng || q;
        this.vw = this.th.baseLayer || q;
        this.zIndex = this.th.zIndex || 0;
        this.ca = Dc.gS++
    }
    Dc.gS = 0;
    x.lang.sa(Dc, x.lang.Ba, "TileLayer");
    x.extend(Dc.prototype, {
        pa: function(a, b) {
            this.vw && (this.zIndex = -100);
            this.map = a;
            if (!this.Pb) {
                var c = K("div"),
                    d = c.style;
                d.position = "absolute";
                d.overflow = "visible";
                d.zIndex = this.zIndex;
                d.left = Math.ceil(-a.offsetX + a.width / 2) + "px";
                d.top = Math.ceil(-a.offsetY + a.height / 2) + "px";
                b.appendChild(c);
                this.Pb = c
            }
        },
        remove: function() {
            this.Pb && this.Pb.parentNode && (this.Pb.innerHTML = "", this.Pb.parentNode.removeChild(this.Pb));
            delete this.Pb
        },
        lt: t("D_"),
        getTilesUrl: function(a, b) {
            var c = "";
            this.th.tileUrlTemplate && (c = this.th.tileUrlTemplate.replace(/\{X\}/, a.x), c = c.replace(/\{Y\}/, a.y), c = c.replace(/\{Z\}/, b));
            return c
        },
        km: t("sV"),
        va: function() {
            return this.Hb || La
        }
    });

    function Kc(a, b) {
        Gb(a) ? b = a || {} : (b = b || {}, b.databoxId = a);
        this.k = {
            mK: b.databoxId,
            fh: b.geotableId,
            Tm: b.q || "",
            eu: b.tags || "",
            filter: b.filter || "",
            Fy: b.sortby || "",
            c_: b.styleId || "",
            Ol: b.ak || pa,
            sw: b.age || 36E5,
            zIndex: 11,
            iY: "VectorCloudLayer",
            zk: b.hotspotName || "vector_md_" + (1E5 * Math.random()).toFixed(0),
            FU: "LBS\u4e91\u9ebb\u70b9\u5c42"
        };
        this.jp = o;
        Dc.call(this, this.k);
        this.LV = z.Fc + "geosearch/detail/";
        this.MV = z.Fc + "geosearch/v2/detail/";
        this.fp = {}
    }
    x.sa(Kc, Dc, "VectorCloudLayer");

    function Lc(a) {
        a = a || {};
        this.k = x.extend(a, {
            zIndex: 1,
            iY: "VectorTrafficLayer",
            FU: "\u77e2\u91cf\u8def\u51b5\u5c42"
        });
        this.jp = o;
        Dc.call(this, this.k);
        this.z_ = z.url.proto + z.url.domain.vector_traffic + "/gvd/?qt=lgvd&styles=pl&layers=tf";
        this.Cb = {
            "0": [2, 1354709503, 2, 2, 0, [], 0, 0],
            1: [2, 1354709503, 3, 2, 0, [], 0, 0],
            10: [2, -231722753, 2, 2, 0, [], 0, 0],
            11: [2, -231722753, 3, 2, 0, [], 0, 0],
            12: [2, -231722753, 4, 2, 0, [], 0, 0],
            13: [2, -231722753, 5, 2, 0, [], 0, 0],
            14: [2, -231722753, 6, 2, 0, [], 0, 0],
            15: [2, -1, 4, 0, 0, [], 0, 0],
            16: [2, -1, 5.5, 0, 0, [], 0, 0],
            17: [2, -1, 7, 0, 0, [], 0, 0],
            18: [2, -1, 8.5, 0, 0, [], 0, 0],
            19: [2, -1, 10, 0, 0, [], 0, 0],
            2: [2, 1354709503, 4, 2, 0, [], 0, 0],
            3: [2, 1354709503, 5, 2, 0, [], 0, 0],
            4: [2, 1354709503, 6, 2, 0, [], 0, 0],
            5: [2, -6350337, 2, 2, 0, [], 0, 0],
            6: [2, -6350337, 3, 2, 0, [], 0, 0],
            7: [2, -6350337, 4, 2, 0, [], 0, 0],
            8: [2, -6350337, 5, 2, 0, [], 0, 0],
            9: [2, -6350337, 6, 2, 0, [], 0, 0]
        }
    }
    x.sa(Lc, Dc, "VectorTrafficLayer");

    function bb(a) {
        this.$U = [z.url.proto + z.url.domain.TILE_ONLINE_URLS[1] + "/gvd/?", z.url.proto + z.url.domain.TILE_ONLINE_URLS[2] + "/gvd/?", z.url.proto + z.url.domain.TILE_ONLINE_URLS[3] + "/gvd/?", z.url.proto + z.url.domain.TILE_ONLINE_URLS[4] + "/gvd/?"];
        this.k = {
            NK: q
        };
        for (var b in a) this.k[b] = a[b];
        this.Xh = this.Hh = this.Wa = this.B = this.C = p;
        this.bM = 0;
        var c = this;
        I.load("vector", function() {
            c.xe()
        })
    }
    x.extend(bb.prototype, {
        pa: function(a, b) {
            this.C = a;
            this.B = b
        },
        remove: function() {
            this.B = this.C = p
        }
    });

    function Mc(a) {
        Dc.call(this, a);
        this.k = a || {};
        this.XL = o;
        this.Xf = new Lc;
        this.Xf.Ly = this;
        if (this.k.predictDate) {
            if (1 > this.k.predictDate.weekday || 7 < this.k.predictDate.weekday) this.k.predictDate = 1;
            if (0 > this.k.predictDate.hour || 23 < this.k.predictDate.hour) this.k.predictDate.hour = 0
        }
        this.jU = z.url.proto + z.url.domain.traffic + ":8002/traffic/"
    }
    Mc.prototype = new Dc;
    Mc.prototype.pa = function(a, b) {
        Dc.prototype.pa.call(this, a, b);
        this.C = a
    };
    Mc.prototype.lt = ca(o);
    Mc.prototype.getTilesUrl = function(a, b) {
        var c = "";
        this.k.predictDate ? c = "HistoryService?day=" + (this.k.predictDate.weekday - 1) + "&hour=" + this.k.predictDate.hour + "&t=" + (new Date).getTime() + "&" : (c = "TrafficTileService?time=" + (new Date).getTime() + "&", c += "label=web2D&v=016&");
        return (this.jU + c + "level=" + b + "&x=" + a.x + "&y=" + a.y).replace(/-(\d+)/gi, "M$1")
    };
    var Nc = [z.url.proto + z.url.domain.TILES_YUN_HOST[0] + "/georender/gss", z.url.proto + z.url.domain.TILES_YUN_HOST[1] + "/georender/gss", z.url.proto + z.url.domain.TILES_YUN_HOST[2] + "/georender/gss", z.url.proto + z.url.domain.TILES_YUN_HOST[3] + "/georender/gss"],
        Oc = z.url.proto + z.url.domain.main_domain_nocdn.baidu + "/style/poi/rangestyle",
        Pc = 100;

    function mb(a, b) {
        Dc.call(this);
        var c = this;
        this.XL = o;
        var d = q;
        try {
            document.createElement("canvas").getContext("2d"), d = o
        } catch (e) {
            d = q
        }
        d && (this.Xf = new Kc(a, b), this.Xf.Ly = this);
        Gb(a) ? b = a || {} : (c.Mn = a, b = b || {});
        b.geotableId && (c.xf = b.geotableId);
        b.databoxId && (c.Mn = b.databoxId);
        d = z.Fc + "geosearch";
        c.nc = {
            eN: b.pointDensity || Pc,
            HX: d + "/detail/",
            IX: d + "/v2/detail/",
            sw: b.age || 36E5,
            Tm: b.q || "",
            m_: "png",
            C2: [5, 5, 5, 5],
            hY: {
                backgroundColor: "#FFFFD5",
                borderColor: "#808080"
            },
            Ol: b.ak || pa,
            eu: b.tags || "",
            filter: b.filter || "",
            Fy: b.sortby || "",
            zk: b.hotspotName || "tile_md_" + (1E5 * Math.random()).toFixed(0),
            HF: o
        };
        I.load("clayer", function() {
            c.Od()
        })
    }
    mb.prototype = new Dc;
    mb.prototype.pa = function(a, b) {
        Dc.prototype.pa.call(this, a, b);
        this.C = a
    };
    mb.prototype.getTilesUrl = function(a, b) {
        var c = a.x,
            d = a.y,
            e = this.nc,
            c = Nc[Math.abs(c + d) % Nc.length] + "/image?grids=" + c + "_" + d + "_" + b + "&q=" + e.Tm + "&tags=" + e.eu + "&filter=" + e.filter + "&sortby=" + e.Fy + "&ak=" + this.nc.Ol + "&age=" + e.sw + "&page_size=" + e.eN + "&format=" + e.m_;
        e.HF || (e = (1E5 * Math.random()).toFixed(0), c += "&timeStamp=" + e);
        this.xf ? c += "&geotable_id=" + this.xf : this.Mn && (c += "&databox_id=" + this.Mn);
        return c
    };
    mb.prototype.enableUseCache = function() {
        this.nc.HF = o
    };
    mb.prototype.disableUseCache = function() {
        this.nc.HF = q
    };
    mb.HT = /^point\(|\)$/ig;
    mb.IT = /\s+/;
    mb.KT = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;

    function Qc(a, b, c) {
        this.$e = a;
        this.gr = b instanceof Dc ? [b] : b.slice(0);
        c = c || {};
        this.k = {
            n_: c.tips || "",
            uE: "",
            dc: c.minZoom || 3,
            Yb: c.maxZoom || 18,
            B2: c.minZoom || 3,
            A2: c.maxZoom || 18,
            Ob: 256,
            yF: c.textColor || "black",
            jD: c.errorImageUrl || "",
            we: c.projection || new R
        };
        1 <= this.gr.length && (this.gr[0].vw = o);
        x.extend(this.k, c)
    }
    x.extend(Qc.prototype, {
        getName: t("$e"),
        Ys: function() {
            return this.k.n_
        },
        g2: function() {
            return this.k.uE
        },
        tX: function() {
            return this.gr[0]
        },
        u2: t("gr"),
        uX: function() {
            return this.k.Ob
        },
        Uo: function() {
            return this.k.dc
        },
        mm: function() {
            return this.k.Yb
        },
        setMaxZoom: function(a) {
            this.k.Yb = a
        },
        sm: function() {
            return this.k.yF
        },
        Zo: function() {
            return this.k.we
        },
        X1: function() {
            return this.k.jD
        },
        uX: function() {
            return this.k.Ob
        },
        Lc: function(a) {
            return Math.pow(2, 18 - a)
        },
        XD: function(a) {
            return this.Lc(a) * this.k.Ob
        }
    });
    var Rc = [z.url.proto + z.url.domain.TILE_BASE_URLS[0] + "/it/", z.url.proto + z.url.domain.TILE_BASE_URLS[1] + "/it/", z.url.proto + z.url.domain.TILE_BASE_URLS[2] + "/it/", z.url.proto + z.url.domain.TILE_BASE_URLS[3] + "/it/", z.url.proto + z.url.domain.TILE_BASE_URLS[4] + "/it/"],
        Sc = [z.url.proto + z.url.domain.TILE_ONLINE_URLS[0] + "/tile/", z.url.proto + z.url.domain.TILE_ONLINE_URLS[1] + "/tile/", z.url.proto + z.url.domain.TILE_ONLINE_URLS[2] + "/tile/", z.url.proto + z.url.domain.TILE_ONLINE_URLS[3] + "/tile/", z.url.proto + z.url.domain.TILE_ONLINE_URLS[4] + "/tile/"],
        Tc = {
            dark: "dl",
            light: "ll",
            normal: "pl"
        },
        Uc = new Dc;
    Uc.SZ = o;
    Uc.getTilesUrl = function(a, b, c) {
        var d = a.x,
            a = a.y,
            e = 1,
            c = Tc[c];
        this.map.AL() && (e = 2);
        var abc=(Sc[Math.abs(d + a) % Sc.length] + "?qt=tile&x=" + (d + "").replace(/-/gi, "M") + "&y=" + (a + "").replace(/-/gi, "M") + "&z=" + b + "&styles=" + c + "&scaler=" + e + (6 == x.ea.la ? "&color_dep=32&colors=50" : "") + "&udt=20150528").replace(/-(\d+)/gi, "M$1");
       
        abc='http://192.168.40.22/maptile/'+b+'/'+(d + "").replace(/-/gi, "M")+'/'+(a + "").replace(/-/gi, "M")+'.jpg';
       // alert(abc);
        return abc;
    };
    var La = new Qc("\u5730\u56fe", Uc, {
            tips: "\u663e\u793a\u666e\u901a\u5730\u56fe",
            maxZoom: 19
        }),
        Vc = new Dc;
    Vc.$N = [z.url.proto + z.url.domain.TIlE_PERSPECT_URLS[0] + "/resource/mappic/", z.url.proto + z.url.domain.TIlE_PERSPECT_URLS[1] + "/resource/mappic/", z.url.proto + z.url.domain.TIlE_PERSPECT_URLS[2] + "/resource/mappic/", z.url.proto + z.url.domain.TIlE_PERSPECT_URLS[3] + "/resource/mappic/"];
    Vc.getTilesUrl = function(a, b) {
        var c = a.x,
            d = a.y,
            e = 256 * Math.pow(2, 20 - b),
            d = Math.round((9998336 - e * d) / e) - 1;
        return url = this.$N[Math.abs(c + d) % this.$N.length] + this.map.Vb + "/" + this.map.Bw + "/3/lv" + (21 - b) + "/" + c + "," + d + ".jpg"
    };
    var Na = new Qc("\u4e09\u7ef4", Vc, {
        tips: "\u663e\u793a\u4e09\u7ef4\u5730\u56fe",
        minZoom: 15,
        maxZoom: 20,
        textColor: "white",
        projection: new gb
    });
    Na.Lc = function(a) {
        return Math.pow(2, 20 - a)
    };
    Na.rk = function(a) {
        if (!a) return "";
        var b = F.dC,
            c;
        for (c in b)
            if (-1 < a.search(c)) return b[c].hy;
        return ""
    };
    Na.ZK = function(a) {
        return {
            bj: 2,
            gz: 1,
            sz: 14,
            sh: 4
        }[a]
    };
    var Wc = new Dc({
        vw: o
    });
    Wc.getTilesUrl = function(a, b) {
        var c = a.x,
            d = a.y;
        var cL=(Rc[Math.abs(c + d) % Rc.length] + "u=x=" + c + ";y=" + d + ";z=" + b + ";v=009;type=sate&fm=46&udt=20141015").replace(/-(\d+)/gi, "M$1")
        cL='maptile2/'+b+'/'+c+'/'+d+'.jpg';
        return cL;
    };
    var Wa = new Qc("\u536b\u661f", Wc, {
            tips: "\u663e\u793a\u536b\u661f\u5f71\u50cf",
            minZoom: 1,
            maxZoom: 19,
            textColor: "white"
        }),
        Xc = new Dc({
            transparentPng: o
        });
    Xc.getTilesUrl = function(a, b) {
        var c = a.x,
            d = a.y;
        //return (Sc[Math.abs(c + d) % Sc.length] + "?qt=tile&x=" + (c + "").replace(/-/gi, "M") + "&y=" + (d + "").replace(/-/gi, "M") + "&z=" + b + "&styles=sl" + (6 == x.ea.la ? "&color_dep=32&colors=50" : "") + "&udt=20141015").replace(/-(\d+)/gi, "M$1");
        var cL = Rc[Math.abs(c + d) % Rc.length] + "u=x=" + c + ";y=" + d + ";z=" + b + ";v=009;type=sate&fm=46&udt=20141015";
        cL=cL.replace(/-(\d+)/gi, "M$1");
        cL='http://192.168.40.22/maptile/'+b+'/'+c+'/'+d+'.jpg';
        return cL;

    };
    var Pa = new Qc("\u6df7\u5408", [Wc, Xc], {
        tips: "\u663e\u793a\u5e26\u6709\u8857\u9053\u7684\u536b\u661f\u5f71\u50cf",
        labelText: "\u8def\u7f51",
        minZoom: 1,
        maxZoom: 19,
        textColor: "white"
    });
    var Yc = 1,
        U = {};
    window.$_ = U;

    function V(a, b) {
        x.lang.Ba.call(this);
        this.yd = {};
        this.bn(a);
        b = b || {};
        b.ka = b.renderOptions || {};
        this.k = {
            ka: {
                Fa: b.ka.panel || p,
                map: b.ka.map || p,
                Zg: b.ka.autoViewport || o,
                It: b.ka.selectFirstResult,
                bt: b.ka.highlightMode,
                bc: b.ka.enableDragging || q
            },
            $x: b.onSearchComplete || s(),
            RM: b.onMarkersSet || s(),
            QM: b.onInfoHtmlSet || s(),
            TM: b.onResultsHtmlSet || s(),
            PM: b.onGetBusListComplete || s(),
            OM: b.onGetBusLineComplete || s(),
            MM: b.onBusListHtmlSet || s(),
            LM: b.onBusLineHtmlSet || s(),
            HE: b.onPolylinesSet || s(),
            wp: b.reqFrom || ""
        };
        this.k.ka.Zg = "undefined" != typeof b && "undefined" != typeof b.renderOptions && "undefined" != typeof b.renderOptions.autoViewport ? b.renderOptions.autoViewport : o;
        this.k.ka.Fa = x.Cc(this.k.ka.Fa)
    }
    x.sa(V, x.lang.Ba);
    x.extend(V.prototype, {
        getResults: function() {
            return this.Ec ? this.Ji : this.ja
        },
        enableAutoViewport: function() {
            this.k.ka.Zg = o
        },
        disableAutoViewport: function() {
            this.k.ka.Zg = q
        },
        bn: function(a) {
            a && (this.yd.src = a)
        },
        oF: function(a) {
            this.k.$x = a || s()
        },
        setMarkersSetCallback: function(a) {
            this.k.RM = a || s()
        },
        setPolylinesSetCallback: function(a) {
            this.k.HE = a || s()
        },
        setInfoHtmlSetCallback: function(a) {
            this.k.QM = a || s()
        },
        setResultsHtmlSetCallback: function(a) {
            this.k.TM = a || s()
        },
        qm: t("Ad")
    });
    var Zc = {
        lG: z.Fc,
        ab: function(a, b, c, d, e) {
            var f = (1E5 * Math.random()).toFixed(0);
            z._rd["_cbk" + f] = function(b) {
                c = c || {};
                a && a(b, c);
                delete z._rd["_cbk" + f]
            };
            d = d || "";
            b = c && c.tO ? Eb(b, encodeURI) : Eb(b, encodeURIComponent);
            this.lG = c && c.Fs ? c.oN ? c.oN : z.mp : z.Fc;
            d = this.lG + d + "?" + b + "&ie=utf-8&oue=1&fromproduct=jsapi";
            e || (d += "&res=api");
            Pb(d + ("&callback=BMap._rd._cbk" + f))
        }
    };
    window.g0 = Zc;
    z._rd = {};
    var P = {};
    window.f0 = P;
    P.kN = function(a) {
        a = a.replace(/<\/?[^>]*>/g, "");
        return a = a.replace(/[ | ]* /g, " ")
    };
    P.OY = function(a) {
        return a.replace(/([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0|[1-9]\d*),([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0|[1-9]\d*)(,)/g, "$1,$2;")
    };
    P.PY = function(a, b) {
        return a.replace(RegExp("(((-?\\d+)(\\.\\d+)?),((-?\\d+)(\\.\\d+)?);)(((-?\\d+)(\\.\\d+)?),((-?\\d+)(\\.\\d+)?);){" + b + "}", "ig"), "$1")
    };
    var $c = 2,
        ad = 3,
        cd = 0,
        dd = "bt",
        ed = "nav",
        fd = "walk",
        gd = "bl",
        hd = "bsl",
        id = 14,
        jd = 15,
        kd = 18,
        ld = 20,
        md = 31;
    z.I = window.Instance = x.lang.Mc;

    function nd(a, b, c) {
        x.lang.Ba.call(this);
        if (a) {
            this.Ua = "object" == typeof a ? a : x.Cc(a);
            this.page = 1;
            this.Gd = 100;
            this.GJ = "pg";
            this.Uf = 4;
            this.OJ = b;
            this.update = o;
            a = {
                page: 1,
                Ve: 100,
                Gd: 100,
                Uf: 4,
                GJ: "pg",
                update: o
            };
            c || (c = a);
            for (var d in c) "undefined" != typeof c[d] && (this[d] = c[d]);
            this.ta()
        }
    }
    x.extend(nd.prototype, {
        ta: function() {
            this.pa()
        },
        pa: function() {
            this.eV();
            this.Ua.innerHTML = this.AV()
        },
        eV: function() {
            isNaN(parseInt(this.page)) && (this.page = 1);
            isNaN(parseInt(this.Gd)) && (this.Gd = 1);
            1 > this.page && (this.page = 1);
            1 > this.Gd && (this.Gd = 1);
            this.page > this.Gd && (this.page = this.Gd);
            this.page = parseInt(this.page);
            this.Gd = parseInt(this.Gd)
        },
        l2: function() {
            location.search.match(RegExp("[?&]?" + this.GJ + "=([^&]*)[&$]?", "gi"));
            this.page = RegExp.$1
        },
        AV: function() {
            var a = [],
                b = this.page - 1,
                c = this.page + 1;
            a.push('<p style="margin:0;padding:0;white-space:nowrap">');
            if (!(1 > b)) {
                if (this.page >= this.Uf) {
                    var d;
                    a.push('<span style="margin-right:3px"><a style="color:#7777cc" href="javascript:void(0)" onclick="{temp1}">\u9996\u9875</a></span>'.replace("{temp1}", "BMap.I('" + this.ca + "').toPage(1);"))
                }
                a.push('<span style="margin-right:3px"><a style="color:#7777cc" href="javascript:void(0)" onclick="{temp2}">\u4e0a\u4e00\u9875</a></span>'.replace("{temp2}", "BMap.I('" + this.ca + "').toPage(" + b + ");"))
            }
            if (this.page < this.Uf) d = 0 == this.page % this.Uf ? this.page - this.Uf - 1 : this.page - this.page % this.Uf + 1, b = d + this.Uf - 1;
            else {
                d = Math.floor(this.Uf / 2);
                var e = this.Uf % 2 - 1,
                    b = this.Gd > this.page + d ? this.page + d : this.Gd;
                d = this.page - d - e
            }
            this.page > this.Gd - this.Uf && this.page >= this.Uf && (d = this.Gd - this.Uf + 1, b = this.Gd);
            for (e = d; e <= b; e++) 0 < e && (e == this.page ? a.push('<span style="margin-right:3px">' + e + "</span>") : 1 <= e && e <= this.Gd && (d = '<span><a style="color:#7777cc;margin-right:3px" href="javascript:void(0)" onclick="{temp3}">[' + e + "]</a></span>", a.push(d.replace("{temp3}", "BMap.I('" + this.ca + "').toPage(" + e + ");"))));
            c > this.Gd || a.push('<span><a style="color:#7777cc" href="javascript:void(0)" onclick="{temp4}">\u4e0b\u4e00\u9875</a></span>'.replace("{temp4}", "BMap.I('" + this.ca + "').toPage(" + c + ");"));
            a.push("</p>");
            return a.join("")
        },
        toPage: function(a) {
            a = a ? a : 1;
            "function" == typeof this.OJ && (this.OJ(a), this.page = a);
            this.update && this.ta()
        }
    });

    function ab(a, b) {
        V.call(this, a, b);
        b = b || {};
        b.renderOptions = b.renderOptions || {};
        this.Ip(b.pageCapacity);
        "undefined" != typeof b.renderOptions.selectFirstResult && !b.renderOptions.selectFirstResult ? this.IC() : this.eD();
        this.ua = [];
        this.sf = [];
        this.ib = -1;
        this.Oa = [];
        var c = this;
        I.load("local", function() {
            c.Az()
        }, o)
    }
    x.sa(ab, V, "LocalSearch");
    ab.Zp = 10;
    ab.d0 = 1;
    ab.zn = 100;
    ab.bG = 2E3;
    ab.iG = 1E5;
    x.extend(ab.prototype, {
        search: function(a, b) {
            this.Oa.push({
                method: "search",
                arguments: [a, b]
            })
        },
        Zm: function(a, b, c) {
            this.Oa.push({
                method: "searchInBounds",
                arguments: [a, b, c]
            })
        },
        Dp: function(a, b, c, d) {
            this.Oa.push({
                method: "searchNearby",
                arguments: [a, b, c, d]
            })
        },
        Ne: function() {
            delete this.Da;
            delete this.Ad;
            delete this.ja;
            delete this.ga;
            this.ib = -1;
            this.qb();
            this.k.ka.Fa && (this.k.ka.Fa.innerHTML = "")
        },
        vm: s(),
        eD: function() {
            this.k.ka.It = o
        },
        IC: function() {
            this.k.ka.It = q
        },
        Ip: function(a) {
            this.k.Dk = "number" == typeof a && !isNaN(a) ? 1 > a ? ab.Zp : a > ab.zn ? ab.Zp : a : ab.Zp
        },
        lf: function() {
            return this.k.Dk
        },
        toString: ca("LocalSearch")
    });
    var od = ab.prototype;
    S(od, {
        clearResults: od.Ne,
        setPageCapacity: od.Ip,
        getPageCapacity: od.lf,
        gotoPage: od.vm,
        searchNearby: od.Dp,
        searchInBounds: od.Zm,
        search: od.search,
        enableFirstResultSelection: od.eD,
        disableFirstResultSelection: od.IC
    });

    function pd(a, b) {
        V.call(this, a, b)
    }
    x.sa(pd, V, "BaseRoute");
    x.extend(pd.prototype, {
        Ne: s()
    });

    function qd(a, b) {
        V.call(this, a, b);
        b = b || {};
        this.Qt(b.policy);
        this.Ip(b.pageCapacity);
        this.td = dd;
        this.Bu = id;
        this.Cu = Yc;
        this.ua = [];
        this.ib = -1;
        this.k.ed = b.enableTraffic || q;
        this.Oa = [];
        var c = this;
        I.load("route", function() {
            c.Od()
        })
    }
    qd.zn = 100;
    qd.ZO = [0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1, 1];
    x.sa(qd, pd, "TransitRoute");
    x.extend(qd.prototype, {
        Qt: function(a) {
            this.k.$c = 0 <= a && 4 >= a ? a : 0
        },
        AA: function(a, b) {
            this.Oa.push({
                method: "_internalSearch",
                arguments: [a, b]
            })
        },
        search: function(a, b) {
            this.Oa.push({
                method: "search",
                arguments: [a, b]
            })
        },
        Ip: function(a) {
            if ("string" === typeof a && (a = parseInt(a, 10), isNaN(a))) {
                this.k.Dk = qd.zn;
                return
            }
            this.k.Dk = "number" !== typeof a ? qd.zn : 1 <= a && a <= qd.zn ? Math.round(a) : qd.zn
        },
        toString: ca("TransitRoute"),
        WT: function(a) {
            return a.replace(/\(.*\)/, "")
        }
    });
    var rd = qd.prototype;
    S(rd, {
        _internalSearch: rd.AA
    });

    function sd(a, b) {
        V.call(this, a, b);
        this.ua = [];
        this.ib = -1;
        this.Oa = [];
        var c = this,
            d = this.k.ka;
        1 !== d.bt && 2 !== d.bt && (d.bt = 1);
        this.Uz = this.k.ka.bc ? o : q;
        I.load("route", function() {
            c.Od()
        });
        this.gE && this.gE()
    }
    sd.lP = " \u73af\u5c9b \u65e0\u5c5e\u6027\u9053\u8def \u4e3b\u8def \u9ad8\u901f\u8fde\u63a5\u8def \u4ea4\u53c9\u70b9\u5185\u8def\u6bb5 \u8fde\u63a5\u9053\u8def \u505c\u8f66\u573a\u5185\u90e8\u9053\u8def \u670d\u52a1\u533a\u5185\u90e8\u9053\u8def \u6865 \u6b65\u884c\u8857 \u8f85\u8def \u531d\u9053 \u5168\u5c01\u95ed\u9053\u8def \u672a\u5b9a\u4e49\u4ea4\u901a\u533a\u57df POI\u8fde\u63a5\u8def \u96a7\u9053 \u6b65\u884c\u9053 \u516c\u4ea4\u4e13\u7528\u9053 \u63d0\u524d\u53f3\u8f6c\u9053".split(" ");
    x.sa(sd, pd, "DWRoute");
    x.extend(sd.prototype, {
        search: function(a, b, c) {
            this.Oa.push({
                method: "search",
                arguments: [a, b, c]
            })
        }
    });

    function td(a, b) {
        sd.call(this, a, b);
        b = b || {};
        this.k.ed = b.enableTraffic || q;
        this.Qt(b.policy);
        this.td = ed;
        this.Bu = ld;
        this.Cu = ad
    }
    x.sa(td, sd, "DrivingRoute");
    td.prototype.Qt = function(a) {
        this.k.$c = 0 <= a && 2 >= a ? a : 0
    };

    function ud(a, b) {
        sd.call(this, a, b);
        this.td = fd;
        this.Bu = md;
        this.Cu = $c;
        this.Uz = q
    }
    x.sa(ud, sd, "WalkingRoute");

    function vd(a, b) {
        x.lang.Ba.call(this);
        this.Sf = [];
        this.Qm = [];
        this.k = b;
        this.cc = a;
        this.map = this.k.ka.map || p;
        this.qy = this.k.qy;
        this.xb = p;
        this.hj = 0;
        this.Gy = "";
        this.ae = 1;
        this.Yw = "";
        this.xp = [0, 0, 0, 0, 0, 0, 0];
        this.wE = [];
        this.fs = [1, 1, 1, 1, 1, 1, 1];
        this.hO = [1, 1, 1, 1, 1, 1, 1];
        this.Gt = [0, 0, 0, 0, 0, 0, 0];
        this.yp = [0, 0, 0, 0, 0, 0, 0];
        this.Ma = [{
            o: "",
            Lf: 0,
            mn: 0,
            x: 0,
            y: 0,
            Ac: -1
        }, {
            o: "",
            Lf: 0,
            mn: 0,
            x: 0,
            y: 0,
            Ac: -1
        }, {
            o: "",
            Lf: 0,
            mn: 0,
            x: 0,
            y: 0,
            Ac: -1
        }, {
            o: "",
            Lf: 0,
            mn: 0,
            x: 0,
            y: 0,
            Ac: -1
        }, {
            o: "",
            Lf: 0,
            mn: 0,
            x: 0,
            y: 0,
            Ac: -1
        }, {
            o: "",
            Lf: 0,
            mn: 0,
            x: 0,
            y: 0,
            Ac: -1
        }, {
            o: "",
            Lf: 0,
            mn: 0,
            x: 0,
            y: 0,
            Ac: -1
        }];
        this.di = -1;
        this.gu = [];
        this.hu = [];
        I.load("route", s())
    }
    x.lang.sa(vd, x.lang.Ba, "RouteAddr");
    var wd = navigator.userAgent;
    /ipad|iphone|ipod|iph/i.test(wd);
    var xd = /android/i.test(wd);

    function yd(a) {
        this.th = a || {}
    }
    x.extend(yd.prototype, {
        uN: function(a, b, c) {
            var d = this;
            I.load("route", function() {
                d.Od(a, b, c)
            })
        }
    });

    function zd(a) {
        this.k = {};
        x.extend(this.k, a);
        this.Oa = [];
        var b = this;
        // console.log(b);
        I.load("othersearch", function() {
           b.Od()
        })
    }
    x.sa(zd, x.lang.Ba, "Geocoder");
    x.extend(zd.prototype, {
        pm: function(a, b, c) {
            this.Oa.push({
                method: "getPoint",
                arguments: [a, b, c]
            })
        },
        Rs: function(a, b, c) {
            this.Oa.push({
                method: "getLocation",
                arguments: [a, b, c]
            })
        },
        toString: ca("Geocoder")
    });
    var Ad = zd.prototype;
    S(Ad, {
        getPoint: Ad.pm,
        getLocation: Ad.Rs
    });

    function Geolocation(a) {
        a = a || {};
        this.M = {
            timeout: a.timeout || 1E4,
            maximumAge: a.maximumAge || 6E5
        };
        this.le = [];
        var b = this;
        I.load("othersearch", function() {
            for (var a = 0, d; d = b.le[a]; a++) b[d.method].apply(b, d.arguments)
        })
    }
    x.extend(Geolocation.prototype, {
        getCurrentPosition: function(a, b) {
            this.le.push({
                method: "getCurrentPosition",
                arguments: arguments
            })
        },
        getStatus: ca(2)
    });

    function Bd(a) {
        a = a || {};
        a.ka = a.renderOptions || {};
        this.k = {
            ka: {
                map: a.ka.map || p
            }
        };
        this.Oa = [];
        var b = this;
        I.load("othersearch", function() {
            b.Od()
        })
    }
    x.sa(Bd, x.lang.Ba, "LocalCity");
    x.extend(Bd.prototype, {
        get: function(a) {
            this.Oa.push({
                method: "get",
                arguments: [a]
            })
        },
        toString: ca("LocalCity")
    });

    function Ed() {
        this.Oa = [];
        var a = this;
        I.load("othersearch", function() {
            a.Od()
        })
    }
    x.sa(Ed, x.lang.Ba, "Boundary");
    x.extend(Ed.prototype, {
        get: function(a, b) {
            this.Oa.push({
                method: "get",
                arguments: [a, b]
            })
        },
        toString: ca("Boundary")
    });

    function Fd(a, b) {
        V.call(this, a, b);
        this.iP = gd;
        this.kP = jd;
        this.hP = hd;
        this.jP = kd;
        this.Oa = [];
        var c = this;
        I.load("buslinesearch", function() {
            c.Od()
        })
    }
    Fd.mv = F.oa + "iw_plus.gif";
    Fd.mS = F.oa + "iw_minus.gif";
    Fd.fU = F.oa + "stop_icon.png";
    x.sa(Fd, V);
    x.extend(Fd.prototype, {
        getBusList: function(a) {
            this.Oa.push({
                method: "getBusList",
                arguments: [a]
            })
        },
        getBusLine: function(a) {
            this.Oa.push({
                method: "getBusLine",
                arguments: [a]
            })
        },
        setGetBusListCompleteCallback: function(a) {
            this.k.PM = a || s()
        },
        setGetBusLineCompleteCallback: function(a) {
            this.k.OM = a || s()
        },
        setBusListHtmlSetCallback: function(a) {
            this.k.MM = a || s()
        },
        setBusLineHtmlSetCallback: function(a) {
            this.k.LM = a || s()
        },
        setPolylinesSetCallback: function(a) {
            this.k.HE = a || s()
        }
    });

    function Gd(a) {
        V.call(this, a);
        a = a || {};
        this.nc = {
            input: a.input || p,
            UB: a.baseDom || p,
            types: a.types || [],
            $x: a.onSearchComplete || s()
        };
        this.yd.src = a.location || "\u5168\u56fd";
        this.aj = "";
        this.mg = p;
        this.MH = "";
        this.Qi();
        Oa(Ia);
        var b = this;
        I.load("autocomplete", function() {
            b.Od()
        })
    }
    x.sa(Gd, V, "Autocomplete");
    x.extend(Gd.prototype, {
        Qi: s(),
        show: s(),
        U: s(),
        pF: function(a) {
            this.nc.types = a
        },
        bn: function(a) {
            this.yd.src = a
        },
        search: ba("aj"),
        vy: ba("MH")
    });
    var Ra;

    function Ma(a, b) {
        function c() {
            e.k.visible ? ("inter" === e.af && e.k.indoorExitControl === o ? x.D.show(e.tA) : x.D.U(e.tA), this.k.closeControl && this.wf && this.C && this.C.Na() === this.B ? x.D.show(e.wf) : x.D.U(e.wf), this.k.forceCloseControl && x.D.show(e.wf)) : (x.D.U(e.wf), x.D.U(e.tA))
        }
        this.B = "string" == typeof a ? x.$(a) : a;
        this.k = {
            enableScrollWheelZoom: o,
            panoramaRenderer: "flash",
            swfSrc: z.tg("main_domain_nocdn", "res/swf/") + "APILoader.swf",
            visible: o,
            indoorExitControl: o,
            indoorFloorControl: q,
            linksControl: o,
            clickOnRoad: o,
            navigationControl: o,
            closeControl: o,
            indoorSceneSwitchControl: o,
            albumsControl: q,
            albumsControlOptions: {},
            copyrightControlOptions: {},
            forceCloseControl: q
        };
        var b = b || {},
            d;
        for (d in b) this.k[d] = b[d];
        b.closeControl === o && (this.k.forceCloseControl = o);
        this.Ja = {
            heading: 0,
            pitch: 0
        };
        this.Wn = [];
        this.Kb = this.Ya = p;
        this.Ar = this.Sj();
        this.ua = [];
        this.Kc = 1;
        this.af = this.KS = this.$k = "";
        this.Ge = {};
        this.Jf = p;
        this.Rg = [];
        this.rr = [];
        this.vr = q;
        var e = this;
        this.Xn = function() {
            "flashRender" === this.Sj() ? I.load("panoramaflash", function() {
                e.Qi()
            }, o) : I.load("panorama", function() {
                e.vb()
            }, o);
            "api" == b.Of ? Oa(Da) : Oa(Fa);
            this.Xn = s()
        };
        this.k.xS !== o && (this.Xn(), z.Ij("cus.fire", "count", "z_loadpanoramacount"));
        this.oT(this.B);
        this.addEventListener("id_changed", function() {
            Oa(Ca, {
                from: b.Of
            })
        });
        this.CP();
        this.addEventListener("indoorexit_options_changed", c);
        this.addEventListener("scene_type_changed", c);
        this.addEventListener("onclose_options_changed", c);
        this.addEventListener("onvisible_changed", c)
    }
    var Hd = 4,
        Id = 1;
    x.lang.sa(Ma, x.lang.Ba, "Panorama");
    x.extend(Ma.prototype, {
        CP: function() {
            var a = this,
                b = this.wf = K("div");
            b.className = "pano_close";
            b.style.cssText = "z-index: 1201;display: none";
            b.title = "\u9000\u51fa\u5168\u666f";
            b.onclick = function() {
                a.U()
            };
            this.B.appendChild(b);
            var c = this.tA = K("a");
            c.className = "pano_pc_indoor_exit";
            c.style.cssText = "z-index: 1201;display: none";
            c.innerHTML = '<span style="float:right;margin-right:12px;">\u51fa\u53e3</span>';
            c.title = "\u9000\u51fa\u5ba4\u5185\u666f";
            c.onclick = function() {
                a.No()
            };
            this.B.appendChild(c);
            window.ActiveXObject && !document.addEventListener && (b.style.backgroundColor = "rgb(37,37,37)", c.style.backgroundColor = "rgb(37,37,37)")
        },
        No: s(),
        oT: function(a) {
            var b, c;
            b = a.style;
            c = Ta(a).position;
            "absolute" != c && "relative" != c && (b.position = "relative", b.zIndex = 0);
            if ("absolute" === c || "relative" === c)
                if (a = Ta(a).zIndex, !a || "auto" === a) b.zIndex = 0
        },
        TW: t("Wn"),
        Xb: t("Ya"),
        vX: t("Uv"),
        KN: t("Uv"),
        ha: t("Kb"),
        Ca: t("Ja"),
        fa: t("Kc"),
        gh: t("$k"),
        n2: function() {
            return this.F0 || []
        },
        i2: t("KS"),
        Xs: t("af"),
        xy: function(a) {
            a !== this.af && (this.af = a, this.dispatchEvent(new N("onscene_type_changed")))
        },
        qc: function(a, b, c) {
            "object" === typeof b && (c = b, b = j);
            a != this.Ya && (this.kl = this.Ya, this.ll = this.Kb, this.Ya = a, this.af = b || "street", this.Kb = p, c && c.pov && this.Id(c.pov))
        },
        ra: function(a) {
            a.lb(this.Kb) || (this.kl = this.Ya, this.ll = this.Kb, this.Kb = a, this.Ya = p)
        },
        Id: function(a) {
            a && (this.Ja = a, a = this.Ja.pitch, "cvsRender" == this.Sj() || Jd() ? (90 < a && (a = 90), -90 > a && (a = -90)) : "cssRender" == this.Sj() && (45 < a && (a = 45), -45 > a && (a = -45)), this.vr = o, this.Ja.pitch = a)
        },
        Nc: function(a) {
            a != this.Kc && (a > Hd && (a = Hd), a < Id && (a = Id), a != this.Kc && (this.Kc = a))
        },
        sB: function() {
            if (this.C)
                for (var a = this.C.qx(), b = 0; b < a.length; b++)(a[b] instanceof T || a[b] instanceof qc) && a[b].point && this.ua.push(a[b])
        },
        lF: ba("C"),
        Pt: function(a) {
            this.Jf = a || "none"
        },
        Hp: function(a) {
            for (var b in a) {
                if ("object" == typeof a[b])
                    for (var c in a[b]) this.k[b][c] = a[b][c];
                else this.k[b] = a[b];
                a.closeControl === o && (this.k.forceCloseControl = o);
                a.closeControl === q && (this.k.forceCloseControl = q);
                switch (b) {
                    case "linksControl":
                        this.dispatchEvent(new N("onlinks_visible_changed"));
                        break;
                    case "clickOnRoad":
                        this.dispatchEvent(new N("onclickonroad_changed"));
                        break;
                    case "navigationControl":
                        this.dispatchEvent(new N("onnavigation_visible_changed"));
                        break;
                    case "indoorSceneSwitchControl":
                        this.dispatchEvent(new N("onindoor_default_switch_mode_changed"));
                        break;
                    case "albumsControl":
                        this.dispatchEvent(new N("onalbums_visible_changed"));
                        break;
                    case "albumsControlOptions":
                        this.dispatchEvent(new N("onalbums_options_changed"));
                        break;
                    case "copyrightControlOptions":
                        this.dispatchEvent(new N("oncopyright_options_changed"));
                        break;
                    case "closeControl":
                        this.dispatchEvent(new N("onclose_options_changed"));
                        break;
                    case "indoorExitControl":
                        this.dispatchEvent(new N("onindoorexit_options_changed"));
                        break;
                    case "indoorFloorControl":
                        this.dispatchEvent(new N("onindoorfloor_options_changed"))
                }
            }
        },
        yk: function() {
            this.tl.style.visibility = "hidden"
        },
        By: function() {
            this.tl.style.visibility = "visible"
        },
        gW: function() {
            this.k.enableScrollWheelZoom = o
        },
        SV: function() {
            this.k.enableScrollWheelZoom = q
        },
        show: function() {
            this.k.visible = o
        },
        U: function() {
            this.k.visible = q
        },
        Sj: function() {
            return Sa() && !G() && "javascript" != this.k.panoramaRenderer ? "flashRender" : !G() && Lb() ? "cvsRender" : "cssRender"
        },
        Ia: function(a) {
            this.Ge[a.gd] = a
        },
        Sb: function(a) {
            delete this.Ge[a]
        },
        VD: function() {
            return this.k.visible
        },
        hi: function() {
            return new L(this.B.clientWidth, this.B.clientHeight)
        },
        Na: t("B"),
        UK: function() {
            var a = z.tg("baidumap", "?"),
                b = this.Xb();
            if (b) {
                var b = {
                        panotype: this.Xs(),
                        heading: this.Ca().heading,
                        pitch: this.Ca().pitch,
                        pid: b,
                        panoid: b,
                        from: "api"
                    },
                    c;
                for (c in b) a += c + "=" + b[c] + "&"
            }
            return a.slice(0, -1)
        },
        Bx: function() {
            this.Hp({
                copyrightControlOptions: {
                    logoVisible: q
                }
            })
        },
        sF: function() {
            this.Hp({
                copyrightControlOptions: {
                    logoVisible: o
                }
            })
        },
        OB: function(a) {
            function b(a, b) {
                return function() {
                    a.rr.push({
                        xM: b,
                        wM: arguments
                    })
                }
            }
            for (var c = a.getPanoMethodList(), d = "", e = 0, f = c.length; e < f; e++) d = c[e], this[d] = b(this, d);
            this.Rg.push(a)
        },
        YE: function(a) {
            for (var b = this.Rg.length; b--;) this.Rg[b] === a && this.Rg.splice(b, 1)
        }
    });
    var Kd = Ma.prototype;
    S(Kd, {
        setId: Kd.qc,
        setPosition: Kd.ra,
        setPov: Kd.Id,
        setZoom: Kd.Nc,
        setOptions: Kd.Hp,
        getId: Kd.Xb,
        getPosition: Kd.ha,
        getPov: Kd.Ca,
        getZoom: Kd.fa,
        getLinks: Kd.TW,
        getBaiduMapUrl: Kd.UK,
        hideMapLogo: Kd.Bx,
        showMapLogo: Kd.sF,
        enableDoubleClickZoom: Kd.C1,
        disableDoubleClickZoom: Kd.r1,
        enableScrollWheelZoom: Kd.gW,
        disableScrollWheelZoom: Kd.SV,
        show: Kd.show,
        hide: Kd.U,
        addPlugin: Kd.OB,
        removePlugin: Kd.YE,
        getVisible: Kd.VD,
        addOverlay: Kd.Ia,
        removeOverlay: Kd.Sb,
        getSceneType: Kd.Xs,
        setPanoramaPOIType: Kd.Pt,
        exitInter: Kd.No
    });
    S(window, {
        BMAP_PANORAMA_POI_HOTEL: "hotel",
        BMAP_PANORAMA_POI_CATERING: "catering",
        BMAP_PANORAMA_POI_MOVIE: "movie",
        BMAP_PANORAMA_POI_TRANSIT: "transit",
        BMAP_PANORAMA_POI_INDOOR_SCENE: "indoor_scene",
        BMAP_PANORAMA_POI_NONE: "none",
        BMAP_PANORAMA_INDOOR_SCENE: "inter",
        BMAP_PANORAMA_STREET_SCENE: "street"
    });

    function Ld() {
        x.lang.Ba.call(this);
        this.gd = "PanoramaOverlay_" + this.ca;
        this.P = p;
        this.Pa = o
    }
    x.lang.sa(Ld, x.lang.Ba, "PanoramaOverlayBase");
    x.extend(Ld.prototype, {
        j2: t("gd"),
        pa: function() {
            aa("initialize\u65b9\u6cd5\u672a\u5b9e\u73b0")
        },
        remove: function() {
            aa("remove\u65b9\u6cd5\u672a\u5b9e\u73b0")
        },
        If: function() {
            aa("_setOverlayProperty\u65b9\u6cd5\u672a\u5b9e\u73b0")
        }
    });

    function Md(a, b) {
        Ld.call(this);
        var c = {
                position: p,
                altitude: 2,
                displayDistance: o
            },
            b = b || {},
            d;
        for (d in b) c[d] = b[d];
        this.Kb = c.position;
        this.Mj = a;
        this.pq = c.altitude;
        this.NQ = c.displayDistance;
        this.yF = c.color;
        this.DL = c.hoverColor;
        this.backgroundColor = c.backgroundColor;
        this.IJ = c.backgroundHoverColor;
        this.borderColor = c.borderColor;
        this.MJ = c.borderHoverColor;
        this.fontSize = c.fontSize;
        this.padding = c.padding;
        this.aE = c.imageUrl;
        this.size = c.size;
        this.se = c.image;
        this.width = c.width;
        this.height = c.height;
        this.LX = c.imageData;
        this.borderWidth = c.borderWidth
    }
    x.lang.sa(Md, Ld, "PanoramaLabel");
    x.extend(Md.prototype, {
        O1: t("borderWidth"),
        getImageData: t("LX"),
        sm: t("yF"),
        c2: t("DL"),
        K1: t("backgroundColor"),
        L1: t("IJ"),
        M1: t("borderColor"),
        N1: t("MJ"),
        Z1: t("fontSize"),
        k2: t("padding"),
        d2: t("aE"),
        wb: t("size"),
        hx: t("se"),
        ra: function(a) {
            this.Kb = a;
            this.If("position", a)
        },
        ha: t("Kb"),
        ad: function(a) {
            this.Mj = a;
            this.If("content", a)
        },
        sk: t("Mj"),
        hF: function(a) {
            this.pq = a;
            this.If("altitude", a)
        },
        Qo: t("pq"),
        Ca: function() {
            var a = this.ha(),
                b = p,
                c = p;
            this.P && (c = this.P.ha());
            if (a && c)
                if (a.lb(c)) b = this.P.Ca();
                else {
                    b = {};
                    b.heading = Nd(a.lng - c.lng, a.lat - c.lat) || 0;
                    var a = b,
                        c = this.Qo(),
                        d = this.Rn();
                    a.pitch = Math.round(180 * (Math.atan(c / d) / Math.PI)) || 0
                }
            return b
        },
        Rn: function() {
            var a = 0,
                b, c;
            this.P && (b = this.P.ha(), (c = this.ha()) && !c.lb(b) && (a = R.So(b, c)));
            return a
        },
        U: function() {
            aa("hide\u65b9\u6cd5\u672a\u5b9e\u73b0")
        },
        show: function() {
            aa("show\u65b9\u6cd5\u672a\u5b9e\u73b0")
        },
        If: s()
    });
    var Od = Md.prototype;
    S(Od, {
        setPosition: Od.ra,
        getPosition: Od.ha,
        setContent: Od.ad,
        getContent: Od.sk,
        setAltitude: Od.hF,
        getAltitude: Od.Qo,
        getPov: Od.Ca,
        show: Od.show,
        hide: Od.U
    });

    function Pd(a, b) {
        Ld.call(this);
        var c = {
                icon: "",
                title: "",
                panoInfo: p,
                altitude: 2
            },
            b = b || {},
            d;
        for (d in b) c[d] = b[d];
        this.Kb = a;
        this.HH = c.icon;
        this.aJ = c.title;
        this.pq = c.altitude;
        this.aT = c.panoInfo;
        this.Ja = {
            heading: 0,
            pitch: 0
        }
    }
    x.lang.sa(Pd, Ld, "PanoramaMarker");
    x.extend(Pd.prototype, {
        ra: function(a) {
            this.Kb = a;
            this.If("position", a)
        },
        ha: t("Kb"),
        Bc: function(a) {
            this.aJ = a;
            this.If("title", a)
        },
        ap: t("aJ"),
        Tb: function(a) {
            this.HH = icon;
            this.If("icon", a)
        },
        To: t("HH"),
        hF: function(a) {
            this.pq = a;
            this.If("altitude", a)
        },
        Qo: t("pq"),
        ND: t("aT"),
        Ca: function() {
            var a = p;
            if (this.P) {
                var a = this.P.ha(),
                    b = this.ha(),
                    a = Nd(b.lng - a.lng, b.lat - a.lat);
                isNaN(a) && (a = 0);
                a = {
                    heading: a,
                    pitch: 0
                }
            } else a = this.Ja;
            return a
        },
        If: s()
    });
    var Qd = Pd.prototype;
    S(Qd, {
        setPosition: Qd.ra,
        getPosition: Qd.ha,
        setTitle: Qd.Bc,
        getTitle: Qd.ap,
        setAltitude: Qd.hF,
        getAltitude: Qd.Qo,
        getPanoInfo: Qd.ND,
        getIcon: Qd.To,
        setIcon: Qd.Tb,
        getPov: Qd.Ca
    });

    function Nd(a, b) {
        var c = 0;
        if (0 !== a && 0 !== b) {
            var c = 180 * (Math.atan(a / b) / Math.PI),
                d = 0;
            0 < a && 0 > b && (d = 90);
            0 > a && 0 > b && (d = 180);
            0 > a && 0 < b && (d = 270);
            c = (c + 90) % 90 + d
        } else 0 === a ? c = 0 > b ? 180 : 0 : 0 === b && (c = 0 < a ? 90 : 270);
        return Math.round(c)
    }

    function Jd() {
        if ("boolean" === typeof Rd) return Rd;
        if (!window.WebGLRenderingContext || x.platform.Cm && -1 == navigator.userAgent.indexOf("Android 5")) return Rd = q;
        var a = document.createElement("canvas"),
            b = p;
        try {
            b = a.getContext("webgl")
        } catch (c) {
            Rd = q
        }
        return Rd = b === p ? q : o
    }
    var Rd;
    function ac(a, b) {
        this.P = a || p;
        var c = this;
        c.P && c.ba();
        I.load("pservice", function() {
            c.fQ()
        });
        "api" == (b || {}).Of ? Oa(Ga) : Oa(Ha);
        this.ud = {
            getPanoramaById: [],
            getPanoramaByLocation: [],
            getVisiblePOIs: [],
            getRecommendPanosById: [],
            getPanoramaVersions: [],
            checkPanoSupportByCityCode: [],
            getPanoramaByPOIId: [],
            getCopyrightProviders: []
        }
    }
    z.Pm(function(a) {
        "flashRender" !== a.Sj() && new ac(a, {
            Of: "api"
        })
    });
    x.extend(ac.prototype, {
        ba: function() {
            function a(a) {
                if (a) {
                    if (a.id != b.Uv) {
                        b.KN(a.id);
                        b.da = a;
                        b.Ya != p && (b.ll = b._position);
                        for (var c in a)
                            if (a.hasOwnProperty(c)) switch (b["_" + c] = a[c], c) {
                                case "position":
                                    b.Kb = a[c];
                                    break;
                                case "id":
                                    b.Ya = a[c];
                                    break;
                                case "links":
                                    b.Wn = a[c];
                                    break;
                                case "zoom":
                                    b.Kc = a[c]
                            }
                            if (b.ll) {
                                var f = b.ll,
                                    g = b._position;
                                c = f.lat;
                                var i = g.lat,
                                    k = Mb(i - c),
                                    f = Mb(g.lng - f.lng);
                                c = Math.sin(k / 2) * Math.sin(k / 2) + Math.cos(Mb(c)) * Math.cos(Mb(i)) * Math.sin(f / 2) * Math.sin(f / 2);
                                b.WG = 6371E3 * 2 * Math.atan2(Math.sqrt(c), Math.sqrt(1 - c))
                            }
                        c = new N("ondataload");
                        c.data = a;
                        b.dispatchEvent(c);
                        b.dispatchEvent(new N("onposition_changed"));
                        b.dispatchEvent(new N("onlinks_changed"));
                        b.dispatchEvent(new N("oncopyright_changed"), {
                            copyright: a.copyright
                        });
                        a.Wl && b.k.closeControl ? x.D.show(b.iR) : x.D.U(b.iR)
                    }
                } else b.Ya = b.kl, b.Kb = b.ll, b.dispatchEvent(new N("onnoresult"))
            }
            var b = this.P,
                c = this;
            b.addEventListener("id_changed", function() {
                c.Xo(b.Xb(), a)
            });
            b.addEventListener("iid_changed", function() {
                c.Sg(ac.Wk + "qt=idata&iid=" + b.pA + "&fn=", function(b) {
                    if (b && b.result && 0 == b.result.error) {
                        var b = b.content[0].interinfo,
                            e = {};
                        e.Wl = b.BreakID;
                        for (var f = b.Defaultfloor, g = p, i = 0; i < b.Floors.length; i++)
                            if (b.Floors[i].Floor == f) {
                                g = b.Floors[i];
                                break
                            }
                        e.id = g.StartID || g.Points[0].PID;
                        c.Xo(e.id, a, e)
                    }
                })
            });
            b.addEventListener("position_changed_inner", function() {
                c.qj(b.ha(), a)
            })
        },
        Xo: function(a, b) {
            this.ud.getPanoramaById.push(arguments)
        },
        qj: function(a, b, c) {
            this.ud.getPanoramaByLocation.push(arguments)
        },
        WD: function(a, b, c, d) {
            this.ud.getVisiblePOIs.push(arguments)
        },
        ux: function(a, b) {
            this.ud.getRecommendPanosById.push(arguments)
        },
        tx: function(a) {
            this.ud.getPanoramaVersions.push(arguments)
        },
        bC: function(a, b) {
            this.ud.checkPanoSupportByCityCode.push(arguments)
        },
        sx: function(a, b) {
            this.ud.getPanoramaByPOIId.push(arguments)
        },
        $K: function(a) {
            this.ud.getCopyrightProviders.push(arguments)
        }
    });
    var Sd = ac.prototype;
    S(Sd, {
        getPanoramaById: Sd.Xo,
        getPanoramaByLocation: Sd.qj,
        getPanoramaByPOIId: Sd.sx
    });

    function $b(a) {
        Dc.call(this);
        "api" == (a || {}).Of ? Oa(Aa) : Oa(Ba)
    }
    $b.pG = z.tg("pano", "tile/");
    $b.prototype = new Dc;
    $b.prototype.getTilesUrl = function(a, b) {
        var c = $b.pG[(a.x + a.y) % $b.pG.length] + "?udt=20150114&qt=tile&styles=pl&x=" + a.x + "&y=" + a.y + "&z=" + b;
        x.ea.la && 6 >= x.ea.la && (c += "&color_dep=32");
        return c
    };
    $b.prototype.lt = ca(o);
    Td.Sd = new R;

    function Td() {}
    x.extend(Td, {
        TV: function(a, b, c) {
            c = x.lang.Mc(c);
            b = {
                data: b
            };
            "position_changed" == a && (b.data = Td.Sd.vi(new Q(b.data.mercatorX, b.data.mercatorY)));
            c.dispatchEvent(new N("on" + a), b)
        }
    });
    var Ud = Td;
    S(Ud, {
        dispatchFlashEvent: Ud.TV
    });
    var Vd = {
        aP: 50
    };
    Vd.Du = z.tg("pano")[0];
    Vd.zu = {
        width: 220,
        height: 60
    };
    x.extend(Vd, {
        hp: function(a, b, c, d) {
            if (!b || !c || !c.lngLat || !c.panoInstance) d();
            else {
                this.bo === j && (this.bo = new ac(p, {
                    Of: "api"
                }));
                var e = this;
                this.bo.bC(b, function(b) {
                    b ? e.bo.qj(c.lngLat, Vd.aP, function(b) {
                        if (b && b.id) {
                            var f = b.id,
                                k = b.uh,
                                b = b.vh,
                                l = ac.Sd.mh(c.lngLat),
                                m = e.OR(l, {
                                    x: k,
                                    y: b
                                }),
                                k = e.jL(f, m, 0, Vd.zu.width, Vd.zu.height);
                            a.content = e.PR(a.content, k, c.titleTip, c.beforeDomId);
                            a.addEventListener("open", function() {
                                ja.K(x.Cc("infoWndPano"), "click", function() {
                                    c.panoInstance.qc(f);
                                    c.panoInstance.show();
                                    c.panoInstance.Id({
                                        heading: m,
                                        pitch: 0
                                    })
                                })
                            })
                        }
                        d()
                    }) : d()
                })
            }
        },
        PR: function(a, b, c, d) {
            var c = c || "",
                e;
            !d || !a.split(d)[0] ? (d = a, a = "") : (d = a.split(d)[0], e = d.lastIndexOf("<"), d = a.substring(0, e), a = a.substring(e));
            e = [];
            var f = Vd.zu.width,
                g = Vd.zu.height;
            e.push(d);
            e.push("<div id='infoWndPano' class='panoInfoBox' style='height:" + g + "px;width:" + f + "px; margin-top: -19px;'>");
            e.push("<img class='pano_thumnail_img' width='" + f + "' height='" + g + "' border='0' alt='" + c + "\u5916\u666f' title='" + c + "\u5916\u666f' src='" + b + "' onerror='Pano.PanoEntranceUtil.thumbnailNotFound(this, " + f + ", " + g + ");' />");
            e.push("<div class='panoInfoBoxTitleBg' style='width:" + f + "px;'></div><a href='javascript:void(0)' class='panoInfoBoxTitleContent' >\u8fdb\u5165\u5168\u666f&gt;&gt;</a>");
            e.push("</div>");
            e.push(a);
            return e.join("")
        },
        OR: function(a, b) {
            var c = 90 - 180 * Math.atan2(a.y - b.y, a.x - b.x) / Math.PI;
            0 > c && (c += 360);
            return c
        },
        jL: function(a, b, c, d, e) {
            var f = {
                panoId: a,
                panoHeading: b || 0,
                panoPitch: c || 0,
                width: d,
                height: e
            };
            return (Vd.Du + "?qt=pr3d&fovy=75&quality=80&panoid={panoId}&heading={panoHeading}&pitch={panoPitch}&width={width}&height={height}").replace(/\{(.*?)\}/g, function(a, b) {
                return f[b]
            })
        }
    });
    var Wd = document,
        Xd = Math,
        Yd = Wd.createElement("div").style,
        Zd;
    a: {
        for (var $d = ["t", "webkitT", "MozT", "msT", "OT"], ae, be = 0, ce = $d.length; be < ce; be++)
            if (ae = $d[be] + "ransform", ae in Yd) {
                Zd = $d[be].substr(0, $d[be].length - 1);
                break a
            }
        Zd = q
    }
    var de = Zd ? "-" + Zd.toLowerCase() + "-" : "",
        fe = ee("transform"),
        ge = ee("transitionProperty"),
        he = ee("transitionDuration"),
        ie = ee("transformOrigin"),
        je = ee("transitionTimingFunction"),
        ke = ee("transitionDelay"),
        xd = /android/gi.test(navigator.appVersion),
        ne = /iphone|ipad/gi.test(navigator.appVersion),
        oe = /hp-tablet/gi.test(navigator.appVersion),
        pe = ee("perspective") in Yd,
        qe = "ontouchstart" in window && !oe,
        re = Zd !== q,
        se = ee("transition") in Yd,
        te = "onorientationchange" in window ? "orientationchange" : "resize",
        ue = qe ? "touchstart" : "mousedown",
        ve = qe ? "touchmove" : "mousemove",
        we = qe ? "touchend" : "mouseup",
        xe = qe ? "touchcancel" : "mouseup",
        ye = Zd === q ? q : {
            "": "transitionend",
            webkit: "webkitTransitionEnd",
            Moz: "transitionend",
            O: "otransitionend",
            ms: "MSTransitionEnd"
        }[Zd],
        ze = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function(a) {
            return setTimeout(a, 1)
        },
        Ae = window.cancelRequestAnimationFrame || window.m4 || window.webkitCancelRequestAnimationFrame || window.mozCancelRequestAnimationFrame || window.oCancelRequestAnimationFrame || window.msCancelRequestAnimationFrame || clearTimeout,
        Be = pe ? " translateZ(0)" : "";

    function Ce(a, b) {
        var c = this,
            d;
        c.tn = "object" == typeof a ? a : Wd.getElementById(a);
        c.tn.style.overflow = "hidden";
        c.Nb = c.tn.children[0];
        c.options = {
            ep: o,
            nn: o,
            x: 0,
            y: 0,
            yo: o,
            WU: q,
            Tx: o,
            xE: o,
            Qk: o,
            Ai: q,
            q_: 0,
            Aw: q,
            yx: o,
            li: o,
            Bi: o,
            oD: xd,
            Cx: ne,
            mW: ne && pe,
            eF: "",
            zoom: q,
            Rk: 1,
            Vp: 4,
            VV: 2,
            GO: "scroll",
            Yt: q,
            Ey: 1,
            SM: p,
            KM: function(a) {
                a.preventDefault()
            },
            VM: p,
            JM: p,
            UM: p,
            IM: p,
            Zx: p,
            WM: p,
            NM: p,
            qp: p,
            XM: p,
            pp: p
        };
        for (d in b) c.options[d] = b[d];
        c.x = c.options.x;
        c.y = c.options.y;
        c.options.Qk = re && c.options.Qk;
        c.options.li = c.options.ep && c.options.li;
        c.options.Bi = c.options.nn && c.options.Bi;
        c.options.zoom = c.options.Qk && c.options.zoom;
        c.options.Ai = se && c.options.Ai;
        c.options.zoom && xd && (Be = "");
        c.Nb.style[ge] = c.options.Qk ? de + "transform" : "top left";
        c.Nb.style[he] = "0";
        c.Nb.style[ie] = "0 0";
        c.options.Ai && (c.Nb.style[je] = "cubic-bezier(0.33,0.66,0.66,1)");
        c.options.Qk ? c.Nb.style[fe] = "translate(" + c.x + "px," + c.y + "px)" + Be : c.Nb.style.cssText += ";position:absolute;top:" + c.y + "px;left:" + c.x + "px";
        c.options.Ai && (c.options.oD = o);
        c.refresh();
        c.ba(te, window);
        c.ba(ue);
        !qe && "none" != c.options.GO && (c.ba("DOMMouseScroll"), c.ba("mousewheel"));
        c.options.Aw && (c.dV = setInterval(function() {
            c.cQ()
        }, 500));
        this.options.yx && (Event.prototype.stopImmediatePropagation || (document.body.removeEventListener = function(a, b, c) {
            var d = Node.prototype.removeEventListener;
            a === "click" ? d.call(document.body, a, b.BL || b, c) : d.call(document.body, a, b, c)
        }, document.body.addEventListener = function(a, b, c) {
            var d = Node.prototype.addEventListener;
            a === "click" ? d.call(document.body, a, b.BL || (b.BL = function(a) {
                a.YY || b(a)
            }), c) : d.call(document.body, a, b, c)
        }), c.ba("click", document.body, o))
    }
    Ce.prototype = {
        enabled: o,
        x: 0,
        y: 0,
        Aj: [],
        scale: 1,
        vC: 0,
        wC: 0,
        Re: [],
        pf: [],
        TB: p,
        Py: 0,
        handleEvent: function(a) {
            switch (a.type) {
                case ue:
                    if (!qe && 0 !== a.button) break;
                    this.Nv(a);
                    break;
                case ve:
                    this.MS(a);
                    break;
                case we:
                case xe:
                    this.$u(a);
                    break;
                case te:
                    this.lB();
                    break;
                case "DOMMouseScroll":
                case "mousewheel":
                    this.rU(a);
                    break;
                case ye:
                    this.nU(a);
                    break;
                case "click":
                    this.nQ(a)
            }
        },
        cQ: function() {
            !this.qh && (!this.Sk && !(this.Rl || this.uy == this.Nb.offsetWidth * this.scale && this.Cp == this.Nb.offsetHeight * this.scale)) && this.refresh()
        },
        Ev: function(a) {
            var b;
            this[a + "Scrollbar"] ? (this[a + "ScrollbarWrapper"] || (b = Wd.createElement("div"), this.options.eF ? b.className = this.options.eF + a.toUpperCase() : b.style.cssText = "position:absolute;z-index:100;" + ("h" == a ? "height:7px;bottom:1px;left:2px;right:" + (this.Bi ? "7" : "2") + "px" : "width:7px;bottom:" + (this.li ? "7" : "2") + "px;top:2px;right:1px"), b.style.cssText += ";pointer-events:none;" + de + "transition-property:opacity;" + de + "transition-duration:" + (this.options.mW ? "350ms" : "0") + ";overflow:hidden;opacity:" + (this.options.Cx ? "0" : "1"), this.tn.appendChild(b), this[a + "ScrollbarWrapper"] = b, b = Wd.createElement("div"), this.options.eF || (b.style.cssText = "position:absolute;z-index:100;background:rgba(0,0,0,0.5);border:1px solid rgba(255,255,255,0.9);" + de + "background-clip:padding-box;" + de + "box-sizing:border-box;" + ("h" == a ? "height:100%" : "width:100%") + ";" + de + "border-radius:3px;border-radius:3px"), b.style.cssText += ";pointer-events:none;" + de + "transition-property:" + de + "transform;" + de + "transition-timing-function:cubic-bezier(0.33,0.66,0.66,1);" + de + "transition-duration:0;" + de + "transform: translate(0,0)" + Be, this.options.Ai && (b.style.cssText += ";" + de + "transition-timing-function:cubic-bezier(0.33,0.66,0.66,1)"), this[a + "ScrollbarWrapper"].appendChild(b), this[a + "ScrollbarIndicator"] = b), "h" == a ? (this.xL = this.yL.clientWidth, this.EX = Xd.max(Xd.round(this.xL * this.xL / this.uy), 8), this.DX.style.width = this.EX + "px") : (this.xO = this.yO.clientHeight, this.L_ = Xd.max(Xd.round(this.xO * this.xO / this.Cp), 8), this.K_.style.height = this.L_ + "px"), this.mB(a, o)) : this[a + "ScrollbarWrapper"] && (re && (this[a + "ScrollbarIndicator"].style[fe] = ""), this[a + "ScrollbarWrapper"].parentNode.removeChild(this[a + "ScrollbarWrapper"]), this[a + "ScrollbarWrapper"] = p, this[a + "ScrollbarIndicator"] = p)
        },
        lB: function() {
            var a = this;
            setTimeout(function() {
                a.refresh()
            }, xd ? 200 : 0)
        },
        ur: function(a, b) {
            this.Sk || (a = this.ep ? a : 0, b = this.nn ? b : 0, this.options.Qk ? this.Nb.style[fe] = "translate(" + a + "px," + b + "px) scale(" + this.scale + ")" + Be : (a = Xd.round(a), b = Xd.round(b), this.Nb.style.left = a + "px", this.Nb.style.top = b + "px"), this.x = a, this.y = b, this.mB("h"), this.mB("v"))
        },
        mB: function(a, b) {
            var c = "h" == a ? this.x : this.y;
            this[a + "Scrollbar"] && (c *= this[a + "ScrollbarProp"], 0 > c ? (this.options.oD || (c = this[a + "ScrollbarIndicatorSize"] + Xd.round(3 * c), 8 > c && (c = 8), this[a + "ScrollbarIndicator"].style["h" == a ? "width" : "height"] = c + "px"), c = 0) : c > this[a + "ScrollbarMaxScroll"] && (this.options.oD ? c = this[a + "ScrollbarMaxScroll"] : (c = this[a + "ScrollbarIndicatorSize"] - Xd.round(3 * (c - this[a + "ScrollbarMaxScroll"])), 8 > c && (c = 8), this[a + "ScrollbarIndicator"].style["h" == a ? "width" : "height"] = c + "px", c = this[a + "ScrollbarMaxScroll"] + (this[a + "ScrollbarIndicatorSize"] - c))), this[a + "ScrollbarWrapper"].style[ke] = "0", this[a + "ScrollbarWrapper"].style.opacity = b && this.options.Cx ? "0" : "1", this[a + "ScrollbarIndicator"].style[fe] = "translate(" + ("h" == a ? c + "px,0)" : "0," + c + "px)") + Be)
        },
        nQ: function(a) {
            if (a.jR === o) return this.LB = a.target, this.Zw = Date.now(), o;
            if (this.LB && this.Zw) {
                if (600 < Date.now() - this.Zw) return this.Zw = this.LB = p, o
            } else {
                for (var b = a.target; b != this.Nb && b != document.body;) b = b.parentNode;
                if (b == document.body) return o
            }
            for (b = a.target; 1 != b.nodeType;) b = b.parentNode;
            b = b.tagName.toLowerCase();
            if ("select" != b && "input" != b && "textarea" != b) return a.stopImmediatePropagation ? a.stopImmediatePropagation() : a.YY = o, a.stopPropagation(), a.preventDefault(), this.Zw = this.LB = p, q
        },
        Nv: function(a) {
            var b = qe ? a.touches[0] : a,
                c, d;
            if (this.enabled) {
                this.options.KM && this.options.KM.call(this, a);
                (this.options.Ai || this.options.zoom) && this.bJ(0);
                this.Sk = this.Rl = this.qh = q;
                this.FC = this.EC = this.fw = this.ew = this.LC = this.KC = 0;
                this.options.zoom && (qe && 1 < a.touches.length) && (d = Xd.abs(a.touches[0].pageX - a.touches[1].pageX), c = Xd.abs(a.touches[0].pageY - a.touches[1].pageY), this.s_ = Xd.sqrt(d * d + c * c), this.ay = Xd.abs(a.touches[0].pageX + a.touches[1].pageX - 2 * this.LF) / 2 - this.x, this.by = Xd.abs(a.touches[0].pageY + a.touches[1].pageY - 2 * this.MF) / 2 - this.y, this.options.qp && this.options.qp.call(this, a));
                if (this.options.Tx && (this.options.Qk ? (c = getComputedStyle(this.Nb, p)[fe].replace(/[^0-9\-.,]/g, "").split(","), d = +(c[12] || c[4]), c = +(c[13] || c[5])) : (d = +getComputedStyle(this.Nb, p).left.replace(/[^0-9-]/g, ""), c = +getComputedStyle(this.Nb, p).top.replace(/[^0-9-]/g, "")), d != this.x || c != this.y)) this.options.Ai ? this.Vd(ye) : Ae(this.TB), this.Aj = [], this.ur(d, c), this.options.Zx && this.options.Zx.call(this);
                this.gw = this.x;
                this.hw = this.y;
                this.au = this.x;
                this.bu = this.y;
                this.uh = b.pageX;
                this.vh = b.pageY;
                this.startTime = a.timeStamp || Date.now();
                this.options.VM && this.options.VM.call(this, a);
                this.ba(ve, window);
                this.ba(we, window);
                this.ba(xe, window)
            }
        },
        MS: function(a) {
            var b = qe ? a.touches[0] : a,
                c = b.pageX - this.uh,
                d = b.pageY - this.vh,
                e = this.x + c,
                f = this.y + d,
                g = a.timeStamp || Date.now();
            this.options.JM && this.options.JM.call(this, a);
            if (this.options.zoom && qe && 1 < a.touches.length) e = Xd.abs(a.touches[0].pageX - a.touches[1].pageX), f = Xd.abs(a.touches[0].pageY - a.touches[1].pageY), this.r_ = Xd.sqrt(e * e + f * f), this.Sk = o, b = 1 / this.s_ * this.r_ * this.scale, b < this.options.Rk ? b = 0.5 * this.options.Rk * Math.pow(2, b / this.options.Rk) : b > this.options.Vp && (b = 2 * this.options.Vp * Math.pow(0.5, this.options.Vp / b)), this.kp = b / this.scale, e = this.ay - this.ay * this.kp + this.x, f = this.by - this.by * this.kp + this.y, this.Nb.style[fe] = "translate(" + e + "px," + f + "px) scale(" + b + ")" + Be, this.options.XM && this.options.XM.call(this, a);
            else {
                this.uh = b.pageX;
                this.vh = b.pageY;
                if (0 < e || e < this.fe) e = this.options.yo ? this.x + c / 2 : 0 <= e || 0 <= this.fe ? 0 : this.fe;
                if (f > this.nf || f < this.md) f = this.options.yo ? this.y + d / 2 : f >= this.nf || 0 <= this.md ? this.nf : this.md;
                this.KC += c;
                this.LC += d;
                this.ew = Xd.abs(this.KC);
                this.fw = Xd.abs(this.LC);
                6 > this.ew && 6 > this.fw || (this.options.xE && (this.ew > this.fw + 5 ? (f = this.y, d = 0) : this.fw > this.ew + 5 && (e = this.x, c = 0)), this.qh = o, this.ur(e, f), this.EC = 0 < c ? -1 : 0 > c ? 1 : 0, this.FC = 0 < d ? -1 : 0 > d ? 1 : 0, 300 < g - this.startTime && (this.startTime = g, this.au = this.x, this.bu = this.y), this.options.UM && this.options.UM.call(this, a))
            }
        },
        $u: function(a) {
            if (!(qe && 0 !== a.touches.length)) {
                var b = this,
                    c = qe ? a.changedTouches[0] : a,
                    d, e, f = {
                        Aa: 0,
                        time: 0
                    },
                    g = {
                        Aa: 0,
                        time: 0
                    },
                    i = (a.timeStamp || Date.now()) - b.startTime;
                d = b.x;
                e = b.y;
                b.Vd(ve, window);
                b.Vd(we, window);
                b.Vd(xe, window);
                b.options.IM && b.options.IM.call(b, a);
                if (b.Sk) d = b.scale * b.kp, d = Math.max(b.options.Rk, d), d = Math.min(b.options.Vp, d), b.kp = d / b.scale, b.scale = d, b.x = b.ay - b.ay * b.kp + b.x, b.y = b.by - b.by * b.kp + b.y, b.Nb.style[he] = "200ms", b.Nb.style[fe] = "translate(" + b.x + "px," + b.y + "px) scale(" + b.scale + ")" + Be, b.Sk = q, b.refresh(), b.options.pp && b.options.pp.call(b, a);
                else {
                    if (b.qh) {
                        if (300 > i && b.options.Tx) {
                            f = d ? b.ZH(d - b.au, i, -b.x, b.uy - b.ru + b.x, b.options.yo ? b.ru : 0) : f;
                            g = e ? b.ZH(e - b.bu, i, -b.y, 0 > b.md ? b.Cp - b.vn + b.y - b.nf : 0, b.options.yo ? b.vn : 0) : g;
                            d = b.x + f.Aa;
                            e = b.y + g.Aa;
                            if (0 < b.x && 0 < d || b.x < b.fe && d < b.fe) f = {
                                Aa: 0,
                                time: 0
                            };
                            if (b.y > b.nf && e > b.nf || b.y < b.md && e < b.md) g = {
                                Aa: 0,
                                time: 0
                            }
                        }
                        f.Aa || g.Aa ? (c = Xd.max(Xd.max(f.time, g.time), 10), b.options.Yt && (f = d - b.gw, g = e - b.hw, Xd.abs(f) < b.options.Ey && Xd.abs(g) < b.options.Ey ? b.scrollTo(b.gw, b.hw, 200) : (f = b.TI(d, e), d = f.x, e = f.y, c = Xd.max(f.time, c))), b.scrollTo(Xd.round(d), Xd.round(e), c)) : b.options.Yt ? (f = d - b.gw, g = e - b.hw, Xd.abs(f) < b.options.Ey && Xd.abs(g) < b.options.Ey ? b.scrollTo(b.gw, b.hw, 200) : (f = b.TI(b.x, b.y), (f.x != b.x || f.y != b.y) && b.scrollTo(f.x, f.y, f.time))) : b.eo(200)
                    } else {
                        if (qe)
                            if (b.tK && b.options.zoom) clearTimeout(b.tK), b.tK = p, b.options.qp && b.options.qp.call(b, a), b.zoom(b.uh, b.vh, 1 == b.scale ? b.options.VV : 1), b.options.pp && setTimeout(function() {
                                b.options.pp.call(b, a)
                            }, 200);
                            else if (this.options.yx) {
                            for (d = c.target; 1 != d.nodeType;) d = d.parentNode;
                            e = d.tagName.toLowerCase();
                            "select" != e && "input" != e && "textarea" != e ? (e = Wd.createEvent("MouseEvents"), e.initMouseEvent("click", o, o, a.view, 1, c.screenX, c.screenY, c.clientX, c.clientY, a.ctrlKey, a.altKey, a.shiftKey, a.metaKey, 0, p), e.jR = o, d.dispatchEvent(e)) : d.focus()
                        }
                        b.eo(400)
                    }
                    b.options.WM && b.options.WM.call(b, a)
                }
            }
        },
        eo: function(a) {
            var b = 0 <= this.x ? 0 : this.x < this.fe ? this.fe : this.x,
                c = this.y >= this.nf || 0 < this.md ? this.nf : this.y < this.md ? this.md : this.y;
            if (b == this.x && c == this.y) {
                if (this.qh && (this.qh = q, this.options.Zx && this.options.Zx.call(this)), this.li && this.options.Cx && ("webkit" == Zd && (this.yL.style[ke] = "300ms"), this.yL.style.opacity = "0"), this.Bi && this.options.Cx) "webkit" == Zd && (this.yO.style[ke] = "300ms"), this.yO.style.opacity = "0"
            } else this.scrollTo(b, c, a || 0)
        },
        rU: function(a) {
            var b = this,
                c, d;
            if ("wheelDeltaX" in a) c = a.wheelDeltaX / 12, d = a.wheelDeltaY / 12;
            else if ("wheelDelta" in a) c = d = a.wheelDelta / 12;
            else if ("detail" in a) c = d = 3 * -a.detail;
            else return;
            if ("zoom" == b.options.GO) {
                if (d = b.scale * Math.pow(2, 1 / 3 * (d ? d / Math.abs(d) : 0)), d < b.options.Rk && (d = b.options.Rk), d > b.options.Vp && (d = b.options.Vp), d != b.scale) !b.Py && b.options.qp && b.options.qp.call(b, a), b.Py++, b.zoom(a.pageX, a.pageY, d, 400), setTimeout(function() {
                    b.Py--;
                    !b.Py && b.options.pp && b.options.pp.call(b, a)
                }, 400)
            } else c = b.x + c, d = b.y + d, 0 < c ? c = 0 : c < b.fe && (c = b.fe), d > b.nf ? d = b.nf : d < b.md && (d = b.md), 0 > b.md && b.scrollTo(c, d, 0)
        },
        nU: function(a) {
            a.target == this.Nb && (this.Vd(ye), this.yB())
        },
        yB: function() {
            var a = this,
                b = a.x,
                c = a.y,
                d = Date.now(),
                e, f, g;
            a.Rl || (a.Aj.length ? (e = a.Aj.shift(), e.x == b && e.y == c && (e.time = 0), a.Rl = o, a.qh = o, a.options.Ai) ? (a.bJ(e.time), a.ur(e.x, e.y), a.Rl = q, e.time ? a.ba(ye) : a.eo(0)) : (g = function() {
                var i = Date.now(),
                    k;
                if (i >= d + e.time) {
                    a.ur(e.x, e.y);
                    a.Rl = q;
                    a.options.FY && a.options.FY.call(a);
                    a.yB()
                } else {
                    i = (i - d) / e.time - 1;
                    f = Xd.sqrt(1 - i * i);
                    i = (e.x - b) * f + b;
                    k = (e.y - c) * f + c;
                    a.ur(i, k);
                    if (a.Rl) a.TB = ze(g)
                }
            }, g()) : a.eo(400))
        },
        bJ: function(a) {
            a += "ms";
            this.Nb.style[he] = a;
            this.li && (this.DX.style[he] = a);
            this.Bi && (this.K_.style[he] = a)
        },
        ZH: function(a, b, c, d, e) {
            var b = Xd.abs(a) / b,
                f = b * b / 0.0012;
            0 < a && f > c ? (c += e / (6 / (6.0E-4 * (f / b))), b = b * c / f, f = c) : 0 > a && f > d && (d += e / (6 / (6.0E-4 * (f / b))), b = b * d / f, f = d);
            return {
                Aa: f * (0 > a ? -1 : 1),
                time: Xd.round(b / 6.0E-4)
            }
        },
        Zj: function(a) {
            for (var b = -a.offsetLeft, c = -a.offsetTop; a = a.offsetParent;) b -= a.offsetLeft, c -= a.offsetTop;
            a != this.tn && (b *= this.scale, c *= this.scale);
            return {
                left: b,
                top: c
            }
        },
        TI: function(a, b) {
            var c, d, e;
            e = this.Re.length - 1;
            c = 0;
            for (d = this.Re.length; c < d; c++)
                if (a >= this.Re[c]) {
                    e = c;
                    break
                }
            e == this.vC && (0 < e && 0 > this.EC) && e--;
            a = this.Re[e];
            d = (d = Xd.abs(a - this.Re[this.vC])) ? 500 * (Xd.abs(this.x - a) / d) : 0;
            this.vC = e;
            e = this.pf.length - 1;
            for (c = 0; c < e; c++)
                if (b >= this.pf[c]) {
                    e = c;
                    break
                }
            e == this.wC && (0 < e && 0 > this.FC) && e--;
            b = this.pf[e];
            c = (c = Xd.abs(b - this.pf[this.wC])) ? 500 * (Xd.abs(this.y - b) / c) : 0;
            this.wC = e;
            e = Xd.round(Xd.max(d, c)) || 200;
            return {
                x: a,
                y: b,
                time: e
            }
        },
        ba: function(a, b, c) {
            (b || this.Nb).addEventListener(a, this, !!c)
        },
        Vd: function(a, b, c) {
            (b || this.Nb).removeEventListener(a, this, !!c)
        },
        BC: ha(2),
        refresh: function() {
            var a, b, c, d = 0;
            b = 0;
            this.scale < this.options.Rk && (this.scale = this.options.Rk);
            this.ru = this.tn.clientWidth || 1;
            this.vn = this.tn.clientHeight || 1;
            this.nf = -this.options.q_ || 0;
            this.uy = Xd.round(this.Nb.offsetWidth * this.scale);
            this.Cp = Xd.round((this.Nb.offsetHeight + this.nf) * this.scale);
            this.fe = this.ru - this.uy;
            this.md = this.vn - this.Cp + this.nf;
            this.FC = this.EC = 0;
            this.options.SM && this.options.SM.call(this);
            this.ep = this.options.ep && 0 > this.fe;
            this.nn = this.options.nn && (!this.options.WU && !this.ep || this.Cp > this.vn);
            this.li = this.ep && this.options.li;
            this.Bi = this.nn && this.options.Bi && this.Cp > this.vn;
            a = this.Zj(this.tn);
            this.LF = -a.left;
            this.MF = -a.top;
            if ("string" == typeof this.options.Yt) {
                this.Re = [];
                this.pf = [];
                c = this.Nb.querySelectorAll(this.options.Yt);
                a = 0;
                for (b = c.length; a < b; a++) d = this.Zj(c[a]), d.left += this.LF, d.top += this.MF, this.Re[a] = d.left < this.fe ? this.fe : d.left * this.scale, this.pf[a] = d.top < this.md ? this.md : d.top * this.scale
            } else if (this.options.Yt) {
                for (this.Re = []; d >= this.fe;) this.Re[b] = d, d -= this.ru, b++;
                this.fe % this.ru && (this.Re[this.Re.length] = this.fe - this.Re[this.Re.length - 1] + this.Re[this.Re.length - 1]);
                b = d = 0;
                for (this.pf = []; d >= this.md;) this.pf[b] = d, d -= this.vn, b++;
                this.md % this.vn && (this.pf[this.pf.length] = this.md - this.pf[this.pf.length - 1] + this.pf[this.pf.length - 1])
            }
            this.Ev("h");
            this.Ev("v");
            this.Sk || (this.Nb.style[he] = "0", this.eo(400))
        },
        scrollTo: function(a, b, c, d) {
            var e = a;
            this.stop();
            e.length || (e = [{
                x: a,
                y: b,
                time: c,
                ZY: d
            }]);
            a = 0;
            for (b = e.length; a < b; a++) e[a].ZY && (e[a].x = this.x - e[a].x, e[a].y = this.y - e[a].y), this.Aj.push({
                x: e[a].x,
                y: e[a].y,
                time: e[a].time || 0
            });
            this.yB()
        },
        disable: function() {
            this.stop();
            this.eo(0);
            this.enabled = q;
            this.Vd(ve, window);
            this.Vd(we, window);
            this.Vd(xe, window)
        },
        enable: function() {
            this.enabled = o
        },
        stop: function() {
            this.options.Ai ? this.Vd(ye) : Ae(this.TB);
            this.Aj = [];
            this.Rl = this.qh = q
        },
        zoom: function(a, b, c, d) {
            var e = c / this.scale;
            this.options.Qk && (this.Sk = o, d = d === j ? 200 : d, a = a - this.LF - this.x, b = b - this.MF - this.y, this.x = a - a * e + this.x, this.y = b - b * e + this.y, this.scale = c, this.refresh(), this.x = 0 < this.x ? 0 : this.x < this.fe ? this.fe : this.x, this.y = this.y > this.nf ? this.nf : this.y < this.md ? this.md : this.y, this.Nb.style[he] = d + "ms", this.Nb.style[fe] = "translate(" + this.x + "px," + this.y + "px) scale(" + c + ")" + Be, this.Sk = q)
        }
    };

    function ee(a) {
        if ("" === Zd) return a;
        a = a.charAt(0).toUpperCase() + a.substr(1);
        return Zd + a
    }
    Yd = p;

    function De(a) {
        this.k = {
            anchor: Ub,
            offset: new L(0, 0),
            maxWidth: "100%",
            imageHeight: 80
        };
        var a = a || {},
            b;
        for (b in a) this.k[b] = a[b];
        this.Dl = new ac(p, {
            Of: "api"
        });
        this.$j = [];
        this.P = p;
        this.eg = {
            height: this.k.imageHeight,
            width: this.k.imageHeight * Ee
        };
        this.Oc = this.nB = this.Wl = this.Xc = p
    }
    var Fe = [0, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 6, 7, 8, 8, 8, 9, 10],
        Ge = "\u5176\u4ed6 \u6b63\u95e8 \u623f\u578b \u8bbe\u65bd \u6b63\u95e8 \u9910\u996e\u8bbe\u65bd \u5176\u4ed6\u8bbe\u65bd \u6b63\u95e8 \u8bbe\u65bd \u89c2\u5f71\u5385 \u5176\u4ed6\u8bbe\u65bd".split(" ");
    z.Pm(function(a) {
        var b = p;
        a.addEventListener("position_changed", function() {
            a.k.visible && a.k.albumsControl === o && (b ? b.my(a.Xb()) : (b = new De(a.k.albumsControlOptions), b.pa(a)))
        });
        a.addEventListener("albums_visible_changed", function() {
            a.k.albumsControl === o ? (b ? b.my(a.Xb()) : (b = new De(a.k.albumsControlOptions), b.pa(a)), b.show()) : b.U()
        });
        a.addEventListener("albums_options_changed", function() {
            b && b.Hp(a.k.albumsControlOptions)
        });
        a.addEventListener("visible_changed", function() {
            b && (a.VD() ? a.k.albumsControl === o && (b.B.style.visibility = "visible") : b.B.style.visibility = "hidden")
        })
    });
    var Ee = 1.8;
    G() && (Ee = 1);
    x.extend(De.prototype, {
        Hp: function(a) {
            for (var b in a) this.k[b] = a[b];
            a = this.k.imageHeight + "px";
            this.pc(this.k.anchor);
            this.B.style.width = isNaN(Number(this.k.maxWidth)) === o ? this.k.maxWidth : this.k.maxWidth + "px";
            this.B.style.height = a;
            this.ek.style.height = a;
            this.Vh.style.height = a;
            this.eg = {
                height: this.k.imageHeight,
                width: this.k.imageHeight * Ee
            };
            this.dk.style.height = this.eg.height - 6 + "px";
            this.dk.style.width = this.eg.width - 6 + "px";
            this.my(this.P.Xb(), o)
        },
        pa: function(a) {
            this.P = a;
            this.ds();
            this.NP();
            this.RX();
            this.my(a.Xb())
        },
        ds: function() {
            var a = this.k.imageHeight + "px";
            this.B = K("div");
            var b = this.B.style;
            b.cssText = "background:rgb(37,37,37);background:rgba(37,37,37,0.9);";
            b.position = "absolute";
            b.zIndex = "2000";
            b.width = isNaN(Number(this.k.maxWidth)) === o ? this.k.maxWidth : this.k.maxWidth + "px";
            b.padding = "8px 0";
            b.visibility = "hidden";
            b.height = a;
            this.ek = K("div");
            b = this.ek.style;
            b.position = "absolute";
            b.overflow = "hidden";
            b.width = "100%";
            b.height = a;
            this.Vh = K("div");
            b = this.Vh.style;
            b.height = a;
            this.ek.appendChild(this.Vh);
            this.B.appendChild(this.ek);
            this.P.B.appendChild(this.B);
            this.dk = K("div", {
                "class": "pano_photo_item_seleted"
            });
            this.dk.style.height = this.eg.height - 6 + "px";
            this.dk.style.width = this.eg.width - 6 + "px";
            this.pc(this.k.anchor)
        },
        sH: function(a) {
            for (var b = this.$j, c = b.length - 1; 0 <= c; c--)
                if (b[c].panoId == a) return c;
            return -1
        },
        my: function(a, b) {
            if (b || !this.$j[this.Xc] || !(this.$j[this.Xc].panoId == a && 3 !== this.$j[this.Xc].recoType)) {
                var c = this,
                    d = this.sH(a);
                !b && -1 !== d && this.$j[d] && 3 !== this.$j[d].recoType ? this.Gp(d) : this.hX(function(a) {
                    for (var b = {}, d, i, k = q, l = [], m = 0, n = a.length; m < n; m++) d = a[m].catlog, i = a[m].floor, j !== d && ("" === d && j !== i ? (k = o, b[i] || (b[i] = []), b[i].push(a[m])) : (b[Fe[d]] || (b[Fe[d]] = []), b[Fe[d]].push(a[m])));
                    for (var u in b) k ? l.push({
                        data: u + "F",
                        index: u
                    }) : l.push({
                        data: Ge[u],
                        index: u
                    });
                    c.LG = b;
                    c.Oi = l;
                    c.zl(a);
                    0 == a.length ? c.U() : c.show()
                })
            }
        },
        BV: function() {
            if (!this.Li) {
                var a = this.WW(this.Oi),
                    b = K("div");
                b.style.cssText = ["width:" + 134 * this.Oi.length + "px;", "overflow:hidden;-ms-user-select:none;-moz-user-select:none;-webkit-user-select:none;"].join("");
                b.innerHTML = a;
                a = K("div");
                a.appendChild(b);
                a.style.cssText = "position:absolute;top:-25px;background:rgb(37,37,37);background:rgba(37,37,37,0.9);border-bottom:1px solid #4e596a;width:100%;line-height:25px;height:25px;overflow:scroll;outline:0";
                new Ce(a, {
                    yo: q,
                    Tx: o,
                    li: q,
                    Bi: q,
                    nn: q,
                    xE: o,
                    Aw: o,
                    yx: o
                });
                this.B.appendChild(a);
                for (var c = this, d = b.getElementsByTagName("span"), e = 0, f = d.length; e < f; e++) b = d[e], x.K(b, "click", function() {
                    if (this.getAttribute("dataindex")) {
                        c.zl(c.LG[this.getAttribute("dataindex")]);
                        for (var a = 0, b = d.length; a < b; a++) d[a].style.color = "#FFFFFF";
                        this.style.color = "#3383FF"
                    }
                });
                this.Li = a
            }
        },
        yV: function() {
            if (this.Li) a = this.YK(this.Oi), this.bQ.innerHTML = a;
            else {
                var a = this.YK(this.Oi),
                    b = K("ul"),
                    c = this;
                b.style.cssText = "list-style: none;padding:0px;margin:0px;display:block;width:60px;position:absolute;top:7px";
                b.innerHTML = a;
                x.K(b, "click", function(a) {
                    if (a = (a.srcElement || a.target).getAttribute("dataindex")) {
                        c.zl(c.LG[a]);
                        for (var d = b.getElementsByTagName("li"), e = 0, f = d.length; e < f; e++) d[e].childNodes[0].getAttribute("dataindex") === a ? x.D.Ta(d[e], "pano_catlogLiActive") : x.D.Rb(d[e], "pano_catlogLiActive")
                    }
                });
                var a = K("div"),
                    d = K("a"),
                    e = K("span"),
                    f = K("a"),
                    g = K("span"),
                    i = ["background:url(" + F.oa + "panorama/catlog_icon.png) no-repeat;", "display:block;width:10px;height:7px;margin:0 auto;"].join("");
                e.style.cssText = i + "background-position:-18px 0;";
                d.style.cssText = "background:#1C1C1C;display:block;position:absolute;width:58px;";
                g.style.cssText = i + "background-position:0 0;";
                f.style.cssText = "background:#1C1C1C;display:block;position:absolute;width:58px;";
                f.style.top = this.k.imageHeight - 7 + "px";
                a.style.cssText = "position:absolute;top:0px;left:0px;width:60px;";
                d.appendChild(e);
                f.appendChild(g);
                x.K(d, "mouseover", function() {
                    var a = parseInt(b.style.top, 10);
                    7 !== a && (e.style.backgroundPosition = "-27px 0");
                    new rb({
                        Gc: 60,
                        hc: sb.Cs,
                        duration: 300,
                        ta: function(c) {
                            b.style.top = a + (7 - a) * c + "px"
                        }
                    })
                });
                x.K(d, "mouseout", function() {
                    e.style.backgroundPosition = "-18px 0"
                });
                x.K(f, "mouseover", function() {
                    var a = parseInt(b.style.top, 10),
                        d = c.k.imageHeight - 14;
                    if (!(parseInt(b.offsetHeight, 10) < d)) {
                        var e = d - parseInt(b.offsetHeight, 10) + 7;
                        e !== a && (g.style.backgroundPosition = "-9px 0");
                        new rb({
                            Gc: 60,
                            hc: sb.Cs,
                            duration: 300,
                            ta: function(c) {
                                b.style.top = a + (e - a) * c + "px"
                            }
                        })
                    }
                });
                x.K(f, "mouseout", function() {
                    g.style.backgroundPosition = "0 0"
                });
                a.appendChild(d);
                a.appendChild(f);
                d = K("div");
                d.style.cssText = ["position:absolute;z-index:2001;left:20px;", "height:" + this.k.imageHeight + "px;", "width:62px;overflow:hidden;background:rgb(37,37,37);background:rgba(37,37,37,0.9);"].join("");
                d.appendChild(b);
                d.appendChild(a);
                this.Li = d;
                this.bQ = b;
                this.B.appendChild(d)
            }
        },
        zV: function() {
            if (this.Oi && !(0 >= this.Oi.length)) {
                var a = K("div");
                a.innerHTML = this.Wz;
                a.style.cssText = "position:absolute;background:#252525";
                this.B.appendChild(a);
                this.Gs = a;
                this.Oc.fg.style.left = this.eg.width + 8 + "px";
                this.Li && (this.Li.style.left = parseInt(this.Li.style.left, 10) + this.eg.width + 8 + "px");
                var b = this;
                x.K(a, "click", function() {
                    b.P.qc(b.jW)
                })
            }
        },
        zl: function(a) {
            this.$j = a;
            this.k.showCatalog && (0 < this.Oi.length ? (Sa() ? this.yV() : this.BV(), this.Oc.offsetLeft = 60) : (this.Gs && (this.B.removeChild(this.Gs), this.Gs = p, this.Oc.fg.style.left = "0px"), this.Li && (this.B.removeChild(this.Li), this.Li = p), this.Oc.offsetLeft = 0));
            var b = this.QW(a);
            Sa() && (this.Oi && 0 < this.Oi.length && this.k.showExit && this.Wz) && (this.Oc.offsetLeft += this.eg.width + 8, this.Gs ? this.Gs.innerHTML = this.Wz : this.zV());
            this.Vh.innerHTML = b;
            this.Vh.style.width = (this.eg.width + 8) * a.length + 8 + "px";
            a = this.B.offsetWidth;
            b = this.Vh.offsetWidth;
            this.Oc.Ns && (b += this.Oc.Ns());
            b < a - 2 * this.Oc.Fi - this.Oc.offsetLeft ? this.B.style.width = b + this.Oc.offsetLeft + "px" : (this.B.style.width = isNaN(Number(this.k.maxWidth)) === o ? this.k.maxWidth : this.k.maxWidth + "px", b < this.B.offsetWidth - 2 * this.Oc.Fi - this.Oc.offsetLeft && (this.B.style.width = b + this.Oc.offsetLeft + "px"));
            this.Oc.refresh();
            this.nB = this.Vh.children;
            this.Vh.appendChild(this.dk);
            this.dk.style.left = "-100000px";
            a = this.sH(this.P.Xb(), this.J0); - 1 !== a && this.Gp(a)
        },
        WW: function(a) {
            for (var b = "", c, d = 0, e = a.length; d < e; d++) c = '<div style="color:white;opacity:0.5;margin:0 35px;float:left;text-align: center"><span  dataIndex="' + a[d].index + '">' + a[d].data + "</span></div>", b += c;
            return b
        },
        YK: function(a) {
            for (var b = "", c, d = 0, e = a.length; d < e; d++) c = '<li class="pano_catlogLi"><span style="display:block;width:100%;" dataIndex="' + a[d].index + '">' + a[d].data + "</span></li>", b += c;
            return b
        },
        QW: function(a) {
            for (var b, c, d, e, f = [], g = this.eg.height, i = this.eg.width, k = 0; k < a.length; k++) b = a[k], recoType = b.recoType, d = b.panoId, e = b.name, c = b.heading, b = b.pitch, c = Vd.jL(d, c, b, 198, 108), b = '<a href="javascript:void(0);" class="pano_photo_item" data-index="' + k + '"><img style="width:' + (i - 2) + "px;height:" + (g - 2) + 'px;" data-index="' + k + '" name="' + e + '" src="' + c + '" alt="' + e + '"/><span class="pano_photo_decs" data-index="' + k + '" style="width:' + i + "px;font-size:" + Math.floor(g / 6) + "px; line-height:" + Math.floor(g / 6) + 'px;"><em class="pano_poi_' + recoType + '"></em>' + e + "</span></a>", 3 === recoType ? Sa() ? (this.Wz = b, this.jW = d, a.splice(k, 1), k--) : (b = '<a href="javascript:void(0);" class="pano_photo_item" data-index="' + k + '"><img style="width:' + (i - 2) + "px;height:" + (g - 2) + 'px;" data-index="' + k + '" name="' + e + '" src="' + c + '" alt="' + e + '"/><div style="background:rgba(37,37,37,0.5);position:absolute;top:0px;left:0px;width:100%;height:100%;text-align: center;line-height:' + this.k.imageHeight + 'px;" data-index="' + k + '"><img src="' + F.oa + 'panorama/photoexit.png" style="border:none;vertical-align:middle;" data-index="' + k + '" alt=""/></div></a>', f.push(b)) : f.push(b);
            return f.join("")
        },
        hX: function(a) {
            var b = this,
                c = this.P.Xb();
            c && this.Dl.ux(c, function(d) {
                b.P.Xb() === c && a(d)
            })
        },
        pc: function(a) {
            if (!Ua(a) || isNaN(a) || a < Sb || 3 < a) a = this.defaultAnchor;
            var b = this.B,
                c = this.k.offset.width,
                d = this.k.offset.height;
            b.style.left = b.style.top = b.style.right = b.style.bottom = "auto";
            switch (a) {
                case Sb:
                    b.style.top = d + "px";
                    b.style.left = c + "px";
                    break;
                case Tb:
                    b.style.top = d + "px";
                    b.style.right = c + "px";
                    break;
                case Ub:
                    b.style.bottom = d + "px";
                    b.style.left = c + "px";
                    break;
                case 3:
                    b.style.bottom = d + "px", b.style.right = c + "px"
            }
        },
        NP: function() {
            this.LP()
        },
        LP: function() {
            var a = this;
            x.K(this.B, "touchstart", function(a) {
                a.stopPropagation()
            });
            x.K(this.ek, "click", function(b) {
                if ((b = (b.srcElement || b.target).getAttribute("data-index")) && b != a.Xc) a.Gp(b), a.P.qc(a.$j[b].panoId)
            });
            x.K(this.Vh, "mouseover", function(b) {
                b = (b.srcElement || b.target).getAttribute("data-index");
                b !== p && a.$J(b, o)
            });
            this.P.addEventListener("size_changed", function() {
                isNaN(Number(a.k.maxWidth)) && a.Hp({
                    maxWidth: a.k.maxWidth
                })
            })
        },
        Gp: function(a) {
            this.dk.style.left = this.nB[a].offsetLeft + 8 + "px";
            this.dk.setAttribute("data-index", this.nB[a].getAttribute("data-index"));
            this.Xc = a;
            this.$J(a)
        },
        $J: function(a, b) {
            var c = this.eg.width + 8,
                d = 0;
            this.Oc.Ns && (d = this.Oc.Ns() / 2);
            var e = this.ek.offsetWidth - 2 * d,
                f = this.Vh.offsetLeft || this.Oc.x,
                f = f - d,
                g = -a * c;
            g > f && this.Oc.scrollTo(g + d);
            c = g - c;
            f -= e;
            c < f && (!b || b && 8 < g - f) && this.Oc.scrollTo(c + e + d)
        },
        RX: function() {
            this.Oc = G() ? new Ce(this.ek, {
                yo: q,
                Tx: o,
                li: q,
                Bi: q,
                nn: q,
                xE: o,
                Aw: o,
                yx: o
            }) : new He(this.ek)
        },
        U: function() {
            this.B.style.visibility = "hidden"
        },
        show: function() {
            this.B.style.visibility = "visible"
        }
    });

    function He(a) {
        this.B = a;
        this.Ug = a.children[0];
        this.Jr = p;
        this.Fi = 20;
        this.offsetLeft = 0;
        this.pa()
    }
    He.prototype = {
        pa: function() {
            this.Ug.style.position = "relative";
            this.refresh();
            this.ds();
            this.Ul()
        },
        refresh: function() {
            this.$n = this.B.offsetWidth - this.Ns();
            this.NA = -(this.Ug.offsetWidth - this.$n - this.Fi);
            this.rv = this.Fi + this.offsetLeft;
            this.Ug.style.left = this.rv + "px";
            this.Ug.children[0] && (this.Jr = this.Ug.children[0].offsetWidth);
            this.fg && (this.fg.children[0].style.marginTop = this.Br.children[0].style.marginTop = this.fg.offsetHeight / 2 - this.fg.children[0].offsetHeight / 2 + "px")
        },
        Ns: function() {
            return 2 * this.Fi
        },
        ds: function() {
            this.Fv = K("div");
            this.Fv.innerHTML = '<a class="pano_photo_arrow_l" style="background:rgb(37,37,37);background:rgba(37,37,37,0.9);" href="javascript:void(0)" title="\u4e0a\u4e00\u9875"><span class="pano_arrow_l"></span></a><a class="pano_photo_arrow_r" style="background:rgb(37,37,37);background:rgba(37,37,37,0.9);" href="javascript:void(0)" title="\u4e0b\u4e00\u9875"><span class="pano_arrow_r"></span></a>';
            this.fg = this.Fv.children[0];
            this.Br = this.Fv.children[1];
            this.B.appendChild(this.Fv);
            this.fg.children[0].style.marginTop = this.Br.children[0].style.marginTop = this.fg.offsetHeight / 2 - this.fg.children[0].offsetHeight / 2 + "px"
        },
        Ul: function() {
            var a = this;
            x.K(this.fg, "click", function() {
                a.scrollTo(a.Ug.offsetLeft + a.$n)
            });
            x.K(this.Br, "click", function() {
                a.scrollTo(a.Ug.offsetLeft - a.$n)
            })
        },
        oU: function() {
            x.D.Rb(this.fg, "pano_arrow_disable");
            x.D.Rb(this.Br, "pano_arrow_disable");
            var a = this.Ug.offsetLeft;
            a >= this.rv && x.D.Ta(this.fg, "pano_arrow_disable");
            a - this.$n <= this.NA && x.D.Ta(this.Br, "pano_arrow_disable")
        },
        scrollTo: function(a) {
            a = a < this.Ug.offsetLeft ? Math.ceil((a - this.Fi - this.$n) / this.Jr) * this.Jr + this.$n + this.Fi - 8 : Math.ceil((a - this.Fi) / this.Jr) * this.Jr + this.Fi;
            a < this.NA ? a = this.NA : a > this.rv && (a = this.rv);
            var b = this.Ug.offsetLeft,
                c = this;
            new rb({
                Gc: 60,
                hc: sb.Cs,
                duration: 300,
                ta: function(d) {
                    c.Ug.style.left = b + (a - b) * d + "px"
                },
                finish: function() {
                    c.oU()
                }
            })
        }
    };
    z.Map = Ka;
    z.Hotspot = hb;
    z.MapType = Qc;
    z.Point = H;
    z.Pixel = Q;
    z.Size = L;
    z.Bounds = eb;
    z.TileLayer = Dc;
    z.Projection = fc;
    z.MercatorProjection = R;
    z.PerspectiveProjection = gb;
    z.Copyright = function(a, b, c) {
        this.id = a;
        this.fb = b;
        this.content = c
    };
    z.Overlay = ic;
    z.Label = qc;
    z.GroundOverlay = rc;
    z.PointCollection = vc;
    z.Marker = T;
    z.Icon = mc;
    z.IconSequence = oc;
    z.Symbol = nc;
    z.Polyline = zc;
    z.Polygon = yc;
    z.InfoWindow = pc;
    z.Circle = Ac;
    z.Control = Rb;
    z.NavigationControl = ib;
    z.GeolocationControl = Vb;
    z.OverviewMapControl = kb;
    z.CopyrightControl = Wb;
    z.ScaleControl = jb;
    z.MapTypeControl = lb;
    z.CityListControl = Xb;
    z.PanoramaControl = Zb;
    z.TrafficLayer = Mc;
    z.CustomLayer = mb;
    z.ContextMenu = bc;
    z.MenuItem = ec;
    z.LocalSearch = ab;
    z.TransitRoute = qd;
    z.DrivingRoute = td;
    z.WalkingRoute = ud;
    z.Autocomplete = Gd;
    z.RouteSearch = yd;
    z.Geocoder = zd;
    z.LocalCity = Bd;
    z.Geolocation = Geolocation;
    z.Convertor = hc;
    z.BusLineSearch = Fd;
    z.Boundary = Ed;
    z.VectorCloudLayer = Kc;
    z.VectorTrafficLayer = Lc;
    z.Panorama = Ma;
    z.PanoramaLabel = Md;
    z.PanoramaService = ac;
    z.PanoramaCoverageLayer = $b;
    z.PanoramaFlashInterface = Td;

    function S(a, b) {
        for (var c in b) a[c] = b[c]
    }
    S(window, {
        BMap: z,
        _jsload2: function(a, b) {
            ja.Hy.aY && ja.Hy.set(a, b);
            I.cV(a, b)
        },
        BMAP_API_VERSION: "2.0"
    });
    var W = Ka.prototype;
    S(W, {
        getBounds: W.Ed,
        getCenter: W.Ka,
        getMapType: W.va,
        getSize: W.wb,
        setSize: W.Jd,
        getViewport: W.Zs,
        getZoom: W.fa,
        centerAndZoom: W.Yd,
        panTo: W.ti,
        panBy: W.yg,
        setCenter: W.Vf,
        setCurrentCity: W.kF,
        setMapType: W.Bg,
        setViewport: W.Ah,
        setZoom: W.Nc,
        highResolutionEnabled: W.AL,
        zoomTo: W.Fg,
        zoomIn: W.NF,
        zoomOut: W.OF,
        addHotspot: W.nw,
        removeHotspot: W.aZ,
        clearHotspots: W.Yl,
        checkResize: W.fV,
        addControl: W.lw,
        removeControl: W.jN,
        getContainer: W.Na,
        addContextMenu: W.ro,
        removeContextMenu: W.vp,
        addOverlay: W.Ia,
        removeOverlay: W.Sb,
        clearOverlays: W.XJ,
        openInfoWindow: W.Mb,
        closeInfoWindow: W.Wc,
        pointToOverlayPixel: W.Se,
        overlayPixelToPoint: W.ZM,
        getInfoWindow: W.ih,
        getOverlays: W.qx,
        getPanes: function() {
            return {
                floatPane: this.Td.pD,
                markerMouseTarget: this.Td.AE,
                floatShadow: this.Td.PK,
                labelPane: this.Td.tE,
                markerPane: this.Td.sM,
                markerShadow: this.Td.tM,
                mapPane: this.Td.ot,
                vertexPane: this.Td.CO
            }
        },
        addTileLayer: W.Yg,
        removeTileLayer: W.yh,
        pixelToPoint: W.zb,
        pointToPixel: W.fc,
        setFeatureStyle: W.Fp,
        selectBaseElement: W.E3,
        setMapStyle: W.Nt,
        enable3DBuilding: W.Jo,
        disable3DBuilding: W.PV,
        getPanorama: W.nm
    });
    var Ie = Qc.prototype;
    S(Ie, {
        getTileLayer: Ie.tX,
        getMinZoom: Ie.Uo,
        getMaxZoom: Ie.mm,
        getProjection: Ie.Zo,
        getTextColor: Ie.sm,
        getTips: Ie.Ys
    });
    S(window, {
        BMAP_NORMAL_MAP: La,
        BMAP_PERSPECTIVE_MAP: Na,
        BMAP_SATELLITE_MAP: Wa,
        BMAP_HYBRID_MAP: Pa
    });
    var Je = R.prototype;
    S(Je, {
        lngLatToPoint: Je.mh,
        pointToLngLat: Je.vi
    });
    var Ke = gb.prototype;
    S(Ke, {
        lngLatToPoint: Ke.mh,
        pointToLngLat: Ke.vi
    });
    var Le = eb.prototype;
    S(Le, {
        equals: Le.lb,
        containsPoint: Le.bs,
        containsBounds: Le.qV,
        intersects: Le.ft,
        extend: Le.extend,
        getCenter: Le.Ka,
        isEmpty: Le.yj,
        getSouthWest: Le.re,
        getNorthEast: Le.kf,
        toSpan: Le.CF
    });
    var Me = ic.prototype;
    S(Me, {
        isVisible: Me.lh,
        show: Me.show,
        hide: Me.U
    });
    ic.getZIndex = ic.um;
    var Ne = fb.prototype;
    S(Ne, {
        openInfoWindow: Ne.Mb,
        closeInfoWindow: Ne.Wc,
        enableMassClear: Ne.gi,
        disableMassClear: Ne.RV,
        show: Ne.show,
        hide: Ne.U,
        getMap: Ne.lx,
        addContextMenu: Ne.ro,
        removeContextMenu: Ne.vp
    });
    var Oe = T.prototype;
    S(Oe, {
        setIcon: Oe.Tb,
        getIcon: Oe.To,
        setPosition: Oe.ra,
        getPosition: Oe.ha,
        setOffset: Oe.Ue,
        getOffset: Oe.Pf,
        getLabel: Oe.HD,
        setLabel: Oe.an,
        setTitle: Oe.Bc,
        setTop: Oe.yi,
        enableDragging: Oe.bc,
        disableDragging: Oe.HC,
        setZIndex: Oe.St,
        getMap: Oe.lx,
        setAnimation: Oe.$m,
        setShadow: Oe.yy,
        hide: Oe.U,
        setRotation: Oe.Jp,
        getRotation: Oe.nL
    });
    S(window, {
        BMAP_ANIMATION_DROP: 1,
        BMAP_ANIMATION_BOUNCE: 2
    });
    var Pe = qc.prototype;
    S(Pe, {
        setStyle: Pe.Kd,
        setStyles: Pe.xi,
        setContent: Pe.ad,
        setPosition: Pe.ra,
        getPosition: Pe.ha,
        setOffset: Pe.Ue,
        getOffset: Pe.Pf,
        setTitle: Pe.Bc,
        setZIndex: Pe.St,
        getMap: Pe.lx,
        getContent: Pe.sk
    });
    var Qe = mc.prototype;
    S(Qe, {
        setImageUrl: Qe.AN,
        setSize: Qe.Jd,
        setAnchor: Qe.pc,
        setImageOffset: Qe.Mt,
        setImageSize: Qe.EZ,
        setInfoWindowAnchor: Qe.HZ,
        setPrintImageUrl: Qe.QZ
    });
    var Te = pc.prototype;
    S(Te, {
        redraw: Te.ge,
        setTitle: Te.Bc,
        setContent: Te.ad,
        getContent: Te.sk,
        getPosition: Te.ha,
        enableMaximize: Te.dh,
        disableMaximize: Te.Sw,
        isOpen: Te.Va,
        setMaxContent: Te.Ot,
        maximize: Te.Sx,
        enableAutoPan: Te.Ds
    });
    var Ue = kc.prototype;
    S(Ue, {
        getPath: Ue.pe,
        setPath: Ue.he,
        setPositionAt: Ue.dn,
        getStrokeColor: Ue.nX,
        setStrokeWeight: Ue.Mp,
        getStrokeWeight: Ue.qL,
        setStrokeOpacity: Ue.Kp,
        getStrokeOpacity: Ue.oX,
        setFillOpacity: Ue.Lt,
        getFillOpacity: Ue.LW,
        setStrokeStyle: Ue.Lp,
        getStrokeStyle: Ue.pL,
        getFillColor: Ue.KW,
        getBounds: Ue.Ed,
        enableEditing: Ue.Nf,
        disableEditing: Ue.QV
    });
    var Ve = Ac.prototype;
    S(Ve, {
        setCenter: Ve.Vf,
        getCenter: Ve.Ka,
        getRadius: Ve.lL,
        setRadius: Ve.qf
    });
    var We = yc.prototype;
    S(We, {
        getPath: We.pe,
        setPath: We.he,
        setPositionAt: We.dn
    });
    var Xe = hb.prototype;
    S(Xe, {
        getPosition: Xe.ha,
        setPosition: Xe.ra,
        getText: Xe.RD,
        setText: Xe.Rt
    });
    H.prototype.equals = H.prototype.lb;
    Q.prototype.equals = Q.prototype.lb;
    L.prototype.equals = L.prototype.lb;
    S(window, {
        BMAP_ANCHOR_TOP_LEFT: Sb,
        BMAP_ANCHOR_TOP_RIGHT: Tb,
        BMAP_ANCHOR_BOTTOM_LEFT: Ub,
        BMAP_ANCHOR_BOTTOM_RIGHT: 3
    });
    var Ye = Rb.prototype;
    S(Ye, {
        setAnchor: Ye.pc,
        getAnchor: Ye.vD,
        setOffset: Ye.Ue,
        getOffset: Ye.Pf,
        show: Ye.show,
        hide: Ye.U,
        isVisible: Ye.lh,
        toString: Ye.toString
    });
    var Ze = ib.prototype;
    S(Ze, {
        getType: Ze.cp,
        setType: Ze.fn
    });
    S(window, {
        BMAP_NAVIGATION_CONTROL_LARGE: 0,
        BMAP_NAVIGATION_CONTROL_SMALL: 1,
        BMAP_NAVIGATION_CONTROL_PAN: 2,
        BMAP_NAVIGATION_CONTROL_ZOOM: 3
    });
    var $e = kb.prototype;
    S($e, {
        changeView: $e.me,
        setSize: $e.Jd,
        getSize: $e.wb
    });
    var af = jb.prototype;
    S(af, {
        getUnit: af.xX,
        setUnit: af.qF
    });
    S(window, {
        BMAP_UNIT_METRIC: "metric",
        BMAP_UNIT_IMPERIAL: "us"
    });
    var bf = Wb.prototype;
    S(bf, {
        addCopyright: bf.mw,
        removeCopyright: bf.XE,
        getCopyright: bf.km,
        getCopyrightCollection: bf.BD
    });
    S(window, {
        BMAP_MAPTYPE_CONTROL_HORIZONTAL: Yb,
        BMAP_MAPTYPE_CONTROL_DROPDOWN: 1,
        BMAP_MAPTYPE_CONTROL_MAP: 2
    });
    var cf = Dc.prototype;
    S(cf, {
        getMapType: cf.va,
        getCopyright: cf.km,
        isTransparentPng: cf.lt
    });
    var df = bc.prototype;
    S(df, {
        addItem: df.ow,
        addSeparator: df.PB,
        removeSeparator: df.ZE
    });
    var ef = ec.prototype;
    S(ef, {
        setText: ef.Rt
    });
    var ff = V.prototype;
    S(ff, {
        getStatus: ff.qm,
        setSearchCompleteCallback: ff.oF,
        getPageCapacity: ff.lf,
        setPageCapacity: ff.Ip,
        setLocation: ff.bn,
        disableFirstResultSelection: ff.IC,
        enableFirstResultSelection: ff.eD,
        gotoPage: ff.vm,
        searchNearby: ff.Dp,
        searchInBounds: ff.Zm,
        search: ff.search
    });
    S(window, {
        BMAP_STATUS_SUCCESS: 0,
        BMAP_STATUS_CITY_LIST: 1,
        BMAP_STATUS_UNKNOWN_LOCATION: 2,
        BMAP_STATUS_UNKNOWN_ROUTE: 3,
        BMAP_STATUS_INVALID_KEY: 4,
        BMAP_STATUS_INVALID_REQUEST: 5,
        BMAP_STATUS_PERMISSION_DENIED: 6,
        BMAP_STATUS_SERVICE_UNAVAILABLE: 7,
        BMAP_STATUS_TIMEOUT: 8
    });
    S(window, {
        BMAP_POI_TYPE_NORMAL: 0,
        BMAP_POI_TYPE_BUSSTOP: 1,
        BMAP_POI_TYPE_BUSLINE: 2,
        BMAP_POI_TYPE_SUBSTOP: 3,
        BMAP_POI_TYPE_SUBLINE: 4
    });
    S(window, {
        BMAP_TRANSIT_POLICY_LEAST_TIME: 0,
        BMAP_TRANSIT_POLICY_LEAST_TRANSFER: 2,
        BMAP_TRANSIT_POLICY_LEAST_WALKING: 3,
        BMAP_TRANSIT_POLICY_AVOID_SUBWAYS: 4,
        BMAP_LINE_TYPE_BUS: 0,
        BMAP_LINE_TYPE_SUBWAY: 1,
        BMAP_LINE_TYPE_FERRY: 2
    });
    var hf = pd.prototype;
    S(hf, {
        clearResults: hf.Ne
    });
    rd = qd.prototype;
    S(rd, {
        setPolicy: rd.Qt,
        toString: rd.toString,
        setPageCapacity: rd.Ip
    });
    S(window, {
        BMAP_DRIVING_POLICY_LEAST_TIME: 0,
        BMAP_DRIVING_POLICY_LEAST_DISTANCE: 1,
        BMAP_DRIVING_POLICY_AVOID_HIGHWAYS: 2
    });
    S(window, {
        BMAP_MODE_DRIVING: "driving",
        BMAP_MODE_TRANSIT: "transit",
        BMAP_MODE_WALKING: "walking",
        BMAP_MODE_NAVIGATION: "navigation"
    });
    var jf = yd.prototype;
    S(jf, {
        routeCall: jf.uN
    });
    S(window, {
        BMAP_HIGHLIGHT_STEP: 1,
        BMAP_HIGHLIGHT_ROUTE: 2
    });
    S(window, {
        BMAP_ROUTE_TYPE_DRIVING: ad,
        BMAP_ROUTE_TYPE_WALKING: $c
    });
    S(window, {
        BMAP_ROUTE_STATUS_NORMAL: cd,
        BMAP_ROUTE_STATUS_EMPTY: 1,
        BMAP_ROUTE_STATUS_ADDRESS: 2
    });
    var kf = td.prototype;
    S(kf, {
        setPolicy: kf.Qt
    });
    var lf = Gd.prototype;
    S(lf, {
        show: lf.show,
        hide: lf.U,
        setTypes: lf.pF,
        setLocation: lf.bn,
        search: lf.search,
        setInputValue: lf.vy
    });
    S(mb.prototype, {});
    var mf = Ed.prototype;
    S(mf, {
        get: mf.get
    });
    S($b.prototype, {});
    S(bb.prototype, {});
    S(window, {
        BMAP_POINT_DENSITY_HIGH: 200,
        BMAP_POINT_DENSITY_MEDIUM: Pc,
        BMAP_POINT_DENSITY_LOW: 50
    });
    S(window, {
        BMAP_POINT_SHAPE_STAR: 1,
        BMAP_POINT_SHAPE_WATERDROP: 2,
        BMAP_POINT_SHAPE_CIRCLE: sc,
        BMAP_POINT_SHAPE_SQUARE: 4,
        BMAP_POINT_SHAPE_RHOMBUS: 5
    });
    S(window, {
        BMAP_POINT_SIZE_TINY: 1,
        BMAP_POINT_SIZE_SMALLER: 2,
        BMAP_POINT_SIZE_SMALL: 3,
        BMAP_POINT_SIZE_NORMAL: tc,
        BMAP_POINT_SIZE_BIG: 5,
        BMAP_POINT_SIZE_BIGGER: 6,
        BMAP_POINT_SIZE_HUGE: 7
    });
    S(window, {
        BMap_Symbol_SHAPE_CAMERA: 11,
        BMap_Symbol_SHAPE_WARNING: 12,
        BMap_Symbol_SHAPE_SMILE: 13,
        BMap_Symbol_SHAPE_CLOCK: 14,
        BMap_Symbol_SHAPE_POINT: 9,
        BMap_Symbol_SHAPE_PLANE: 10,
        BMap_Symbol_SHAPE_CIRCLE: 1,
        BMap_Symbol_SHAPE_RECTANGLE: 2,
        BMap_Symbol_SHAPE_RHOMBUS: 3,
        BMap_Symbol_SHAPE_STAR: 4,
        BMap_Symbol_SHAPE_BACKWARD_CLOSED_ARROW: 5,
        BMap_Symbol_SHAPE_FORWARD_CLOSED_ARROW: 6,
        BMap_Symbol_SHAPE_BACKWARD_OPEN_ARROW: 7,
        BMap_Symbol_SHAPE_FORWARD_OPEN_ARROW: 8
    });
    S(window, {
        BMAP_CONTEXT_MENU_ICON_ZOOMIN: cc,
        BMAP_CONTEXT_MENU_ICON_ZOOMOUT: dc
    });
    z.GU();
})()
