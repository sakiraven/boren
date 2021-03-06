var IcoRoll = function (e, t) {
    var n = this;
    this._menu = t ? t : false;
    this._tip_free = true;
    this._attrs = {};
    this._back = false;
    this._ctime;
    this._is_scrolling = false;
    this._should_hide_back = false;
    this._menu_showed = false;
    this._can_add_hide_button = true;
    this._first_time = true;
    this._istouching = false;
    this._current_outside = false;
    this._above_size = 0;
    this._under_size = 0;
    this._default_attrs = {
        links: $(".icoroll"),
        time: 2e3,
        tip_distance: 30,
        tip_text: "Click to see more",
        back_enabled: true,
        back_text: "Back",
        mobile_width: 600,
        menu_show_time: 500
    };
    for (attr in this._default_attrs)this._attrs[attr] = this._default_attrs[attr];
    for (attr in e)this._attrs[attr] = e[attr];
    var r = this._attrs.links;
    this._time = this._attrs.time;
    this._init = function () {
        this._window_height = $(window).height();
        r.css("cursor", "pointer");
        $("body").append('<div id="scroll_tip" class="scroll_colors"></div>');
        $("body").append('<div id="scroll_back" ><span class="scroll_colors">' + this._attrs.back_text + "</span></div>");
        this._$ = $("#scroll_tip");
        this._$back = $("#scroll_back");
        this._hideBack();
        var e = this._attrs["menu_show_time"] / 1e3;
        e = "top " + e + "s";
        this._$back.css({transition: e, "-moz-transition": e, "-webkit-transition": e, "-o-transition": e});
        if (!this._attrs.back_enabled)this._$back.css({display: "none"});
        if (this._menu) {
            this._generateMenu();
            this._generateBlocks()
        }
        this._bind();
        $(window).trigger("scroll");
        $(window).trigger("resize");
        $(window).load(function () {
            n._generateBlocks();
            $(window).trigger("scroll")
        });
        if (this._menu) {
            this._generateBlocks();
            this._setMenuTransition()
        }
    };
    this._generateMenu = function () {
        var e = '<div id="scroll_menu"><div id="scroll_show_menu_button" class="icon-menu-2 scroll_colors hide_button"></div>';
        e += '<div id="scroll_up_button" class="hover_colors icon-arrow-up nav" ></div>';
        e += '<ul class="scroll_menu scroll_colors">';
        for (el in this._menu.elements) {
            e += '<li id="menu_scroll_number_' + el + '" >';
            if (this._menu.position && this._menu.position == "right") {
                e += '<a href="' + this._menu.elements[el].href + '" class="scroll_colors ' + this._menu.elements[el]["class"] + '"></a>';
                if (this._menu.elements[el].content)e += '<span class="scroll_colors">' + this._menu.elements[el].content + "</span>"
            } else {
                if (this._menu.elements[el].content)e += '<span class="scroll_colors">' + this._menu.elements[el].content + "</span>";
                e += '<a href="' + this._menu.elements[el].href + '" class="scroll_colors ' + this._menu.elements[el]["class"] + '"></a>'
            }
            e += "</li>"
        }
        e += "</ul>";
        e += '<div id="scroll_down_button" class="hover_colors icon-arrow-down nav" ></div></div>';
        $("body").append(e);
        this._$menu = $(".scroll_menu");
        if (this._menu.position && this._menu.position == "right")$(".scroll_menu li span").css({left: this._$menu.width()}); else $(".scroll_menu li span").css({right: this._$menu.width()});
        if (this._menu.position && this._menu.position == "right")this._$menu.addClass("scroll_right_menu"); else this._$menu.addClass("scroll_left_menu");
        this._$button = $("#scroll_show_menu_button");
        this._$nav_up = $("#scroll_up_button");
        this._$nav_down = $("#scroll_down_button");
        this._$navs = $("#scroll_menu .nav");
        this._setMenuPosition();
        this._setMenuButtons();
        this._countHeights();
        this._setMenuPosition()
    };
    this._setMenuTransition = function () {
        var e = this._attrs["menu_show_time"] / 1e3;
        var t = "opacity " + e + "s, right " + e + "s, left " + e + "s";
        var n = "top 0.4s," + t;
        this._$menu.css({transition: n, "-moz-transition": n, "-webkit-transition": n, "-o-transition": n});
        this._$navs.css({transition: t, "-moz-transition": t, "-webkit-transition": t, "-o-transition": t})
    };
    this._setMenuButtons = function () {
        if (this._menu.position && this._menu.position == "right") {
            this._$button.addClass("right");
            this._$navs.addClass("right")
        } else {
            this._$button.addClass("left");
            this._$navs.addClass("left")
        }
    };
    this._setMenuPosition = function () {
        this._$menu.css("top", this._above_size);
        this._$menu.css("display", "block");
        this._mousestep = this._$menu.find("li").height();
        this._menu_height = this._$menu.height()
    };
    this._countHeights = function () {
        if (this._menu_height < n._window_height - this._above_size - this._under_size)this._above_size = (n._window_height - this._menu_height) / 2; else this._above_size += this._$nav_up.height();
        this._under_size = this._$nav_down.height();
        this._menu_visible_elements = Math.round((n._window_height - this._above_size - this._under_size) / this._$menu.find("li").height());
        this._menu_center_element = Math.ceil(this._menu_visible_elements / 2)
    };
    this._generateBlocks = function () {
        this._blocks = [];
        for (i in this._menu.elements)if ($(this._menu.elements[i].href).length > 0)this._blocks[$(this._menu.elements[i].href).offset().top] = this._menu.elements[i].href
    };
    this._linkScrollEvent = function (e) {
        this._back = e.offset().top - n._window_height / 2;
        var t = e.attr("data-href");
        var r = e.attr("data-back") ? e.attr("data-back") : "";
        this._$back.find("span").html(this._attrs.back_text + " " + r);
        if (!t)t = e.attr("href");
        this._scroll(e, $(t));
        if (e.attr("data-noback") == null) {
            this._showBack()
        }
    };
    this._scroll = function (e, t, n) {
        var r = this;
        this._is_scrolling = true;
        this._should_hide_back = false;
        var i = typeof e == "number" ? e : e.offset().top;
        var s = typeof t == "number" ? t : t.offset().top;
        var o = $("body").height();
        var u = Math.abs(i - s) / o * this._time;
        $("html,body").animate({scrollTop: s - this._$back.height()}, u, function () {
            r._is_scrolling = false;
            if (n)n()
        });
        this._ctime = u
    };
    this._bind = function () {
        this._bindLinks();
        this._bindScroll();
        this._bindBack();
        if (this._menu) {
            this._bindMenu();
            this._bindNavs();
            this._bindBrowserLocation();
            this._bindBrowserBack()
        }
        this._bindResize();
        this._bindShowButton()
    };
    this._bindLinks = function () {
        var e = this;
        r.bind("click", function (t) {
            e._linkScrollEvent($(this));
            t.preventDefault();
            return false
        });
        r.hover(function () {
            var t = $(this).attr("data-title") ? $(this).attr("data-title") : e._attrs.tip_text;
            e._$.html("<span>" + t + "</span>");
            if (e._attrs.tip_distance)var n = e._attrs.tip_distance; else var n = $(this).height() > e._$.height() ? $(this).height() : e._$.height();
            var r = $(this).offset().top - n;
            var i = $(this).offset().left + $(this).width() / 2 - e._$.width() / 2;
            e._$.css({top: r, left: i});
            e._$.addClass("scroll_tip_show")
        }, function () {
            e._$.removeClass("scroll_tip_show")
        })
    };
    this._bindBack = function () {
        var e = this;
        this._$back.bind("click", function (t) {
            if (e._ctime == null || e._ctime == 0)e._ctime = 200;
            if (e._back) {
                $("html,body").animate({scrollTop: e._back}, e._ctime);
                e._hideBack()
            }
            t.preventDefault();
            return false
        })
    };
    this._bindResize = function () {
        var e = this;
        $(window).bind("resize", function () {
            if (!e._menu)return;
            e._window_height = $(window).height();
            e._generateBlocks();
            e._above_size = 0;
            e._under_size = 0;
            if ($(window).width() < e._attrs.mobile_width) {
                if (e._first_time) {
                    e._hideMenu();
                    e._first_time = false
                }
                e._showButton();
                e._above_size = e._$button.height()
            } else {
                e._showMenu();
                e._hideButton()
            }
            if (e._window_height - e._above_size < e._menu_height) {
                e._showUpDownButtons();
                e._countHeights()
            } else {
                e._above_size = (e._window_height - e._menu_height) / 2;
                e._hideUpDownButtons()
            }
            e._setMenuPosition()
        })
    };
    this._bindBrowserBack = function () {
        $(window).on("popstate", function (e) {
            e.stopPropagation();
            e.preventDefault();
            return false
        })
    };
    this._bindBrowserLocation = function () {
        $(window).on("hashchange", function (e) {
            var t = window.location.href.substr(window.location.href.indexOf("#"));
            var r = n._$menu.find('a[href="' + t + '"]').first().parent();
            r.trigger("click");
            e.stopPropagation();
            e.preventDefault();
            return false
        })
    };
    this.__menuUp = function (e) {
        var t = parseInt(n._$menu.css("top"));
        if (t + n._mousestep > n._above_size)n._$menu.css("top", n._above_size); else n._$menu.css("top", t + n._mousestep);
        e.preventDefault();
        return false
    };
    this.__menuDown = function (e) {
        var t = parseInt(n._$menu.css("top"));
        var r = n._window_height - n._under_size;
        if (t + n._menu_height - n._mousestep < r)n._$menu.css("top", r - n._menu_height); else n._$menu.css("top", t - n._mousestep);
        e.preventDefault();
        return false
    };
    this._bindNavs = function () {
        var e = this;
        this._$nav_up.click(this.__menuUp);
        this._$nav_down.click(this.__menuDown)
    };
    this._bindShowButton = function () {
        var e = this;
        $(document).on("click", ".hide_button", function () {
            e.__buttonShowHideMenuEvent()
        })
    };
    this.__buttonShowHideMenuEvent = function () {
        if (!this._menu_showed) {
            this._showMenu();
            this._menu_showed = true
        } else {
            this._hideMenu();
            this._menu_showed = false
        }
    };
    this._bindMenu = function () {
        var e = this;
        var t = function (t) {
            if (!t)var t = this;
            if (e._istouching)return false;
            e._hideBack();
            var n = e._current.offset().top;
            if (n < e._$nav_up.offset().top || n > e._$nav_down.offset().top) {
                e._current_outside = true
            } else e._current_outside = false;
            var r = $(t).find("a").attr("href");
            var i = $(t);
            if (r.match(/^http/))r = r.match(/#([a-z0-9_]+)/)[0];
            e._scroll($(window).scrollTop(), $(r), function () {
                e._current_outside = false;
                e._saveToHistory(i)
            });
            return false
        };
        var n = function () {
            var t = $(this);
            var n = $(this).find("a");
            var r = $(this).find("span");
            t.siblings().css("left", 0);
            var i = e.__checkBrowser();
            if (i.browser == "msie" && parseInt(i.version) < 8)return false;
            if (e._menu.position && e._menu.position == "right")t.css("left", -(parseInt(r.width()) + parseInt(r.css("padding-right")))); else t.css("left", parseInt(r.width()) + parseInt(r.css("padding-left")))
        };
        var r = function () {
            $(this).css("left", 0)
        };
        this.menuHover = n;
        this.menuUnhover = r;
        this._$menu.find("li").hover(function (e) {
            n.call(this)
        }, function (e) {
            r.call(this)
        });
        this._$menu.find("a").click(function (e) {
            e.preventDefault();
            t($(this).parent().get());
            return false
        });
        this._$menu.find("li").click(function (e) {
            t(this)
        });
        var i = this._$menu.find("li").get();
        if (i[0]["addEventListener"])for (el in i) {
            i[el].addEventListener("touchstart", function (t) {
                t.stopPropagation();
                t.preventDefault();
                e._mousey = t.touches[0].screenY;
                e._mousestep = e._$menu.find("a").height();
                e._touchtime = (new Date).getTime();
                e._istouching = true
            }, false);
            i[el].addEventListener("touchend", function (i) {
                e._istouching = false;
                var s = (new Date).getTime();
                if (Math.abs(s - e._touchtime) < 200) {
                    if (e._current != null)r.call(e._current);
                    t(this);
                    if (!$(this).hasClass("current") || $(this).hasClass("hided")) {
                        n.call($(this));
                        $(this).removeClass("hided")
                    } else $(this).addClass("hided")
                } else {
                    r.call(e._current)
                }
            }, false);
            i[el].addEventListener("touchmove", function (t) {
                t.stopPropagation();
                t.preventDefault();
                var n = e._mousey - t.touches[0].screenY;
                n = -n;
                if (Math.abs(n) < e._mousestep)n = n > 0 ? e._mousestep : -e._mousestep;
                n = n * 2;
                nvalue = parseInt(e._$menu.css("top")) + n;
                var i = nvalue + parseInt(e._menu_height);
                var s = nvalue - e._above_size;
                if (i <= e._window_height)return e._$menu.css("top", e._window_height - e._menu_height - e._under_size);
                if (s >= 0)return e._$menu.css("top", e._above_size);
                e._$menu.css("top", nvalue);
                e._mousey = t.touches[0].screenY;
                r(e._current)
            }, false)
        }
    };
    this._bindScroll = function () {
        var e = this;
        $(window).on("scroll", function () {
            var t = $(window).scrollTop();
            var n = 99999999;
            var r;
            for (i in e._blocks) {
                if (Math.abs(t - i) < n) {
                    n = Math.abs(t - i);
                    r = e._blocks[i]
                }
            }
            if (e._menu) {
                var s = e._$menu.find('a[href="' + r + '"]');
                if (s.length == 0)s = e._$menu.find('a[href*="' + r + '"]');
                e._checkMenu(s.parent())
            }
            if (e._is_scrolling)return;
            if (!e._should_hide_back)return e._should_hide_back = true;
            e._should_hide_back = false;
            e._hideBack()
        });
        if (e._menu)this._$menu.on("mousewheel", function (t) {
            if (e._menu_height < e._window_height - e._above_size - e._under_size)return false;
            if (t.originalEvent.wheelDelta / 120 > 0) {
                e.__menuUp(t)
            } else {
                e.__menuDown(t)
            }
        })
    };
    this._saveToHistory = function (e) {
        //if (!window.history.state || window.history.state.url != e.find("a").attr("href"))if (window.history["pushState"])window.history.pushState({url: e.find("a").attr("href")}, e.find("a").attr("href"), e.find("a").attr("href"))
    };
    this._unbindScroll = function () {
        $(window).unbind("scroll")
    };
    this._hideMenu = function () {
        if (this._menu.position && this._menu.position == "right") {
            this._$navs.css("right", -this._$menu.width());
            this._$menu.css("right", -this._$menu.width())
        } else {
            this._$navs.css("left", -this._$menu.width());
            this._$menu.css("left", -this._$menu.width())
        }
        this._current.css("left", 0);
        this._changeToShowButton()
    };
    this._showMenu = function () {
        if (this._menu.position && this._menu.position == "right") {
            this._$navs.css("right", 0);
            this._$menu.css("right", 0)
        } else {
            this._$navs.css("left", 0);
            this._$menu.css("left", 0)
        }
        this._changeToHideButton()
    };
    this._showUpDownButtons = function () {
        this._$navs.css("display", "block");
        this._$nav_up.css({top: this._above_size, width: this._$menu.find("a").width()});
        this._$nav_down.css({bottom: 0, width: this._$menu.find("a").width()})
    };
    this._hideUpDownButtons = function () {
        this._$navs.css("display", "none")
    };
    this._showButton = function () {
        this._$button.css("display", "block")
    };
    this._hideButton = function () {
        this._$button.css("display", "none")
    };
    this._hideBack = function () {
        this._$back.css("top", -this._$back.height())
    };
    this._showBack = function () {
        this._$back.css("top", 0)
    };
    this._changeToHideButton = function () {
        this._$button.removeClass("icon-menu-2");
        this._$button.addClass("icon-close")
    };
    this._changeToShowButton = function () {
        this._$button.removeClass("icon-close");
        this._$button.addClass("icon-menu-2")
    };
    this._checkMenu = function (e) {
        e.siblings().removeClass("current");
        e.addClass("current");
        if (this._menu_timeout_id != null)window.clearTimeout(this._menu_timeout_id);
        this._menu_timeout_id = window.setTimeout(function () {
            n._saveToHistory(e)
        }, 3e3);
        var t = false;
        this._current = e;
        if (this._menu_height < n._window_height - n._above_size - n._under_size || this._current_outside)return;
        var r = e.offset().top;
        var i = this._$menu.offset().top;
        var s = Math.round((r - i) / this._mousestep) + 1;
        if (s < n._menu_center_element)var o = $("#menu_scroll_number_0"); else var o = $("#menu_scroll_number_" + parseInt(s - n._menu_center_element + 1));
        if (s > this._menu.elements.length - (n._menu_visible_elements - n._menu_center_element))var u = $("#menu_scroll_number_" + (this._menu.elements.length - 1)); else var u = $("#menu_scroll_number_" + parseInt(s + (n._menu_visible_elements - n._menu_center_element) - 1));
        var a = $(window).scrollTop();
        var f = o.offset().top - a;
        var l = u.offset().top - a;
        var c = n._window_height - this._under_size;
        var h = this._above_size;
        var p = this._$menu.offset().top - a;
        if (l > c) {
            var d = true;
            t = n._window_height - this._under_size - (l - p) - this._mousestep
        } else if (f < h) {
            var d = false;
            t = this._above_size - (f - p)
        }
        if (t === false)return;
        t = Math.round(t / this._mousestep) * this._mousestep;
        var v = t + parseInt(this._menu_height);
        var p = t - this._above_size;
        if (v <= n._window_height)return n._$menu.css("top", n._window_height - n._menu_height - n._under_size);
        if (p >= 0)return this._$menu.css("top", this._above_size);
        this._$menu.css("top", t)
    };
    this.__checkBrowser = function () {
        uaMatch = function (e) {
            e = e.toLowerCase();
            var t = /(chrome)[ \/]([\w.]+)/.exec(e) || /(webkit)[ \/]([\w.]+)/.exec(e) || /(opera)(?:.*version|)[ \/]([\w.]+)/.exec(e) || /(msie) ([\w.]+)/.exec(e) || e.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec(e) || [];
            return {browser: t[1] || "", version: t[2] || "0"}
        };
        return uaMatch(navigator.userAgent)
    };
    this._init()
};
icoroll = function (e, t) {
    return new IcoRoll(e, t)
}