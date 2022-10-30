function restart_animation(el) {
  el.style.animation = 'none';
  el.offsetHeight; /* trigger reflow */
  el.style.animation = null;
}

function alert_card(text) {
  document.getElementById("content-alert-text").innerHTML = text;
  var el = document.getElementById("content-alert")
  el.style.display = "block"
  restart_animation(el)
}

function alert_card_hide() {
  document.getElementById("content-alert").style.display = "none"
  document.getElementById("content-alert-text").innerHTML = "";
}

/* record usage service */
// function checktypeinput() {
//   var um = document.getElementById("usetype_m");
//   var uf = document.getElementById("usetype_f");
//   var mb = document.getElementById("member_section");
//   var wk = document.getElementById("nonmember_section");
//   if (um.checked) {
//     mb.style.display = "unset"
//     wk.style.display = "none"
//     alert_card_hide()
//   } else if (uf.checked) {
//     mb.style.display = "none"
//     wk.style.display = "unset"
//     alert_card_hide()
//   }
// }

function TextInput(numb) {
  return '<tr>' +
    '<td><span id="Numb' + numb + '">' + (numb + 1) + '</span></td>' +
    '<td><input type="text" name="fullName' + numb + '" id="fullName' + numb + '" placeholder="ชื่อ - นามสกุล"> </td>' +
    '<td><div class="custom-select"><select name="gender' + numb + '" id="gender' + numb + '" class="sononmem">' +
    '<option value="" selected disabled hidden required>เพศ</option>' +
    '<option value="0">ชาย</option>' +
    '<option value="1">หญิง</option>' +
    '</select></div></td>' +
    '<td><input type="number" name="age' + numb + '" min="1" step="1"></td>' +
    '<td><input type="text" name="tel' + numb + '" id="tel' + numb + '" placeholder="เบอร์โทรศัพท์"></td>' +
    '<td><label class="checkbox"><input type="checkbox"><span class="checkmark"></span></label></td>' +
    '</tr>'
}

function resetCount(objekt) {
  count_trainee = 0;
  createNewInput(objekt, count_trainee)
}

function createNewInput(objekt, numb) {
  objekt.last().after(TextInput(numb));
  dropdownCreate()
}

function createNewInput2(objekt, numb) {
  objekt.append(TextInput(numb));
  dropdownCreate()
}

$(document).ready(function () {
  dropdownCreate();
  // checktypeinput();
  /*  เมื่อยกเลิก จะลบค่าทั้งหมด */
  $("form").on('reset', function () {
    resetCount($("#cregis tbody tr"))
    $("#cregis tbody tr").each(function () {
      var tableSize = $("#cregis tbody tr").length;
      if (tableSize != 1) {
        $(this).remove();
      }
    });
    $("#add-row-trainee").prop("disabled", false);
    alert_card_hide()
  });
  /* ตรวจว่า ส่วนสมาชิกเว็บไซต์ไม่มีค่าว่าง*/
  $("form").on('submit', function (e) {
    if (document.getElementById("usetype_m").checked) {
      $("#member_w tbody tr").each(function (index) {
        var text = $(this).find('input[type="text"]')
        if (text[0].value == "") {
          alert_card("กรุณาใส่รหัสสมาชิกให้ครบถ้วน")
          e.preventDefault(e);
          return false;
        }
        alert_card_hide()
      })
    } else {
      $("#walkin tbody tr").each(function (index) {
        var text = $(this).find('input[type="number"]')
        if (text[0].value == "") {
          alert_card("กรุณาใส่จำนวนผู้ใช้ให้ครบถ้วน")
          e.preventDefault(e);
          return false;
        }
        alert_card_hide()
      })
    }
  })
})
// $(".typeselec").click(function () {
// checktypeinput()
// });


var content_alert_cant_delete = "ไม่สามารถลบข้อมูลทั้งหมดได้"

var count_trainee = 0;
$(document).ready(function () {

  // Add new row
  $("#add-row-trainee").click(function () {
    count_trainee++;
    number = count_trainee;
    createNewInput($("#cregis tbody tr"), number)
    if (number >= 4) {
      $("#add-row-trainee").prop("disabled", true);
    }
  })

  // Remove selected rows
  $("#del-row-trainee").click(function () {
    $("#cregis tbody tr").each(function (index) {
      var isChecked = $(this).find('input[type="checkbox"]').is(":checked");
      var tableSize = $("#cregis tbody tr").length;
      if (isChecked) {
        $(this).remove();
        $("#add-row-trainee").prop("disabled", false);
        if (tableSize <= 1) {
          // $(this).find('input[type="checkbox"]').prop("checked", false)
          // alert_card(content_alert_cant_delete)
          createNewInput2($("#cregis tbody"), 0)
        } else {}
      }
    });
    $("#cregis tbody tr").each(function (index) {
      // console.log(index)
      $(this).find("span:first").text(index + 1);
      count_trainee = index;
    });
  });
})



var count_non = 0;

/* เกี่ยวกับ dropdown */
function dropdownCreate() {
  if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
    /* เผื่อได้เขียนโค้ดเพิ่ม */
  } else {
    // some code..
    var x, i, j, l, ll, selElmnt, a, b, c;
    /*look for any elements with the class "custom-select":*/
    x = document.getElementsByClassName("custom-select");
    l = x.length;
    for (i = 0; i < l; i++) {
      var e = x[i].children;
      e[0].style.display = "none";
      selElmnt = x[i].getElementsByTagName("select")[0];
      ll = selElmnt.length;
      if (x[i].getElementsByClassName("select-selected")[0] == null) {
        /*for each element, create a new DIV that will act as the selected item:*/
        a = document.createElement("BOTTON");
        a.setAttribute("type", "botton");
        a.setAttribute("class", "select-selected");
        a.setAttribute("tabindex", "0");
        a.setAttribute("id", "selector_" + i);
        a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
        x[i].appendChild(a);
        /*for each element, create a new DIV that will contain the option list:*/
        b = document.createElement("DIV");
        b.setAttribute("class", "select-items select-hide");
        for (j = 0; j < ll; j++) {
          /*for each option in the original select element,
          create a new DIV that will act as an option item:*/
          c = document.createElement("BOTTON");
          c.innerHTML = selElmnt.options[j].innerHTML;
          // c.setAttribute("type", "botton");
          c.setAttribute("tabindex", "0");
          c.addEventListener("click", function (e) {
            select_child_click(this)
          });
          c.addEventListener("keyup", function (e) {
            select_child(e, this)
          });
          b.appendChild(c);
        }
        x[i].appendChild(b);
        a.addEventListener("click", function (e) {
          // $("#selector_"+i).click(function (e) {
          /*when the select box is clicked, close any other select boxes,
          and open/close the current select box:*/
          e.stopPropagation();
          closeAllSelect(this);
          setTimeout(function () {
            this.nextSibling.classList.toggle("select-hide2");
          }.bind(this), 20);
          this.nextSibling.classList.toggle("select-hide");

          this.classList.toggle("select-arrow-active");
        });
        a.addEventListener("keyup", function (e) {
          toggleListVisibility(e, this)
        })
      }

    }

    function toggleListVisibility(e, that) {
      let openDropDown =
        SPACEBAR_KEY_CODE.includes(e.keyCode) || e.keyCode === ENTER_KEY_CODE;

      if (e.keyCode === ESCAPE_KEY_CODE) {
        that.focus();
        closeAllSelect();
      }

      if (e.type === "click" || openDropDown) {
        e.stopPropagation();
        closeAllSelect(that);
        setTimeout(function () {
          that.nextSibling.classList.toggle("select-hide2");
        }.bind(that), 20);
        that.nextSibling.classList.toggle("select-hide");
        that.classList.toggle("select-arrow-active");
        focusNextElement(that);
      }

      if (e.keyCode === DOWN_ARROW_KEY_CODE) {
        // focusNextListItem(DOWN_ARROW_KEY_CODE);
        focusNextElement(that, 1)
      }

      if (e.keyCode === UP_ARROW_KEY_CODE) {
        focusNextElement(that, 2)

      }
    }

    function select_child_click(that) {
      /*when an item is clicked, update the original select box,
            and the selected item:*/
      var y, i, k, s, h, sl, yl;
      s = that.parentNode.parentNode.getElementsByTagName("select")[0];
      sl = s.length;
      // console.log(sl)
      h = that.parentNode.previousSibling;
      for (i = 0; i < sl; i++) {
        if (s.options[i].innerHTML == that.innerHTML) {
          s.selectedIndex = i;
          h.innerHTML = that.innerHTML;
          y = that.parentNode.getElementsByClassName("same-as-selected");
          yl = y.length;
          for (k = 0; k < yl; k++) {
            y[k].removeAttribute("class");
          }
          that.setAttribute("class", "same-as-selected");
          break;
        }
      }
      h.click();
    }

    function select_child(e, that) {
      let openDropDown =
        SPACEBAR_KEY_CODE.includes(e.keyCode) || e.keyCode === ENTER_KEY_CODE;

      if (e.keyCode === ESCAPE_KEY_CODE) {
        closeAllSelect();
      }

      if (e.keyCode === DOWN_ARROW_KEY_CODE) {
        focusNextElement(that, 1)
      }

      if (e.keyCode === UP_ARROW_KEY_CODE) {
        focusNextElement(that, 2)
      }

      if (e.type === "click" || openDropDown) {
        select_child_click(that)
        focusNextElement(that, 1);
      }
    }


    function closeAllSelect(elmnt) {
      /*a function that will close all select boxes in the document,
      except the current select box:*/
      var x, y, i, xl, yl, arrNo = [];
      x = document.getElementsByClassName("select-items");
      y = document.getElementsByClassName("select-selected");
      xl = x.length;
      yl = y.length;
      for (i = 0; i < yl; i++) {
        if (elmnt == y[i]) {
          arrNo.push(i)
        } else {
          y[i].classList.remove("select-arrow-active");
        }
      }
      for (i = 0; i < xl; i++) {
        if (arrNo.indexOf(i)) {
          x[i].classList.add("select-hide");
          x[i].classList.add("select-hide2");
        }
      }
    }

    function focusNextElement(el, Next) {
      //add all elements we want to include in our selection
      var z = 1;
      var focussableElements = document.querySelectorAll('a:not([disabled]), button:not([disabled]), input[type=number]:not([disabled]),input[type=text]:not([disabled]), [tabindex]:not([disabled]):not([tabindex="-1"])')
      var list = Array.prototype.filter.call(focussableElements, function (item) {
        return item.offsetWidth > 0 || item.offsetHeight > 0 || item === document.activeElement
      });
      // console.log(list)
      var index = list.indexOf(el);
      // return list[index + 1] || list[0];
      if (Next == 2) {
        if (index > 0) {
          list[index - 1].focus();
        } else {
          list[0].focus();
        }
      } else {
        list[index + z].focus();
      }
    }


    /*if the user clicks anywhere outside the select box,
    then close all select boxes:*/
    document.addEventListener("click", closeAllSelect);
  }

}

const SPACEBAR_KEY_CODE = [0, 32];
const ENTER_KEY_CODE = 13;
const DOWN_ARROW_KEY_CODE = 40;
const UP_ARROW_KEY_CODE = 38;
const ESCAPE_KEY_CODE = 27;