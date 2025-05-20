// ///// 100vh 대응
// 동적으로 높이를 계산하여 CSS 변수에 저장
function setDynamicHeight() {
  const viewportHeight = window.innerHeight * 0.01; // 1vh 계산
  document.documentElement.style.setProperty('--js-vh', `${viewportHeight}px`);
}
// 페이지 로드 및 창 크기 변경 시 실행
setDynamicHeight();
window.addEventListener('resize', setDynamicHeight);










document.addEventListener("DOMContentLoaded", function () {

  // Input_text Clear 버튼 기능
  document.querySelectorAll(".bs_input_clear").forEach((clearContainer) => {
    const inputField = clearContainer.querySelector("input[type='text']");
    if (!inputField) return;

    function updateHasTextClass() {
      if (inputField.value.trim() !== "" && document.activeElement === inputField) {
        clearContainer.classList.add("has_text");
      } else {
        clearContainer.classList.remove("has_text");
      }
    }

    inputField.addEventListener("input", updateHasTextClass);
    inputField.addEventListener("focus", updateHasTextClass);
    inputField.addEventListener("blur", updateHasTextClass);

    clearContainer.addEventListener("click", function (event) {
      if (event.target !== inputField) {
        event.preventDefault();
        inputField.value = "";
        inputField.focus();
        updateHasTextClass();
      }
    });
  });





  // Input_date placeholder 글자색상 변경
  const dateInput = document.querySelector('input[type="date"]');
  if (dateInput) {
    function updateColor() {
      if (!dateInput.value) {
        dateInput.style.color = "var(--color_text_placeholder)";
      } else {
        dateInput.style.color = "";
      }
    }
    dateInput.addEventListener("input", updateColor);
    updateColor();
  }





  // Select 열렸을 때 class 추가
  const select = document.querySelector("select");
  if (select) {
    select.addEventListener("click", function () {
      this.classList.toggle("select_open");
    });

    document.addEventListener("click", function (e) {
      if (!select.contains(e.target)) {
        select.classList.remove("select_open");
      }
    });
  }





  // Textarea 글자 수 제한
  // const C_ver_textarea = document.querySelector('.bs_tcount textarea');
  // const C_ver_charCount = document.querySelector('.bs_tcount_count');
  // const C_ver_maxLength = C_ver_textarea.getAttribute('maxlength');

  // C_ver_textarea.addEventListener('input', function() {
  //     const currentLength = C_ver_textarea.value.length;
  //     C_ver_charCount.textContent = `${currentLength}/${C_ver_maxLength}`;
  // });





  // 버튼 클릭 효과
  const rippleButtons = document.querySelectorAll('.bs_bt');

  rippleButtons.forEach(button => {
    button.addEventListener('click', function(e) {
      const circle = document.createElement('span');
      circle.classList.add('bt_ripple');
      this.appendChild(circle);

      const diameter = Math.max(this.offsetWidth, this.offsetHeight);
      const radius = diameter / 2;

      circle.style.width = circle.style.height = `${diameter}px`;
      circle.style.left = `${e.offsetX - radius}px`;
      circle.style.top = `${e.offsetY - radius}px`;
      circle.classList.add('active');

      circle.addEventListener('transitionend', () => {
        circle.remove();
      });
    });
  });


});





// 채팅창 자동 스크롤 기능!!! START
// 스크롤을 맨 아래로 이동하는 함수
function scrollToBottom() {
  const chatBox = document.querySelector('.r_body_classroom_chat_box_talk');
  if (!chatBox) return;
  chatBox.scrollTo({
    top: chatBox.scrollHeight,
    behavior: 'smooth' // 부드럽게 스크롤 (원하지 않으면 제거 가능)
  });
}
// 채팅창 변화 감지 및 자동 스크롤
function observeChatBox() {
  const chatBox = document.querySelector('.r_body_classroom_chat_box_talk');
  if (!chatBox) return;

  const observer = new MutationObserver(() => {
    scrollToBottom();
  });

  observer.observe(chatBox, {
    childList: true,
    subtree: true
  });
}

// DOM 로드 시 자동 실행
document.addEventListener("DOMContentLoaded", function () {
  observeChatBox();
});
// 채팅창 자동 스크롤 기능!!! END





// 채팅창 자동 스크롤 기능!!! START
// 열기 버튼 클릭 시
document.querySelector('.function_01_click_open_chat').addEventListener('click', function () {
  const chatBox = document.querySelector('.function_01_action_chat');
  if (!chatBox.classList.contains('active')) {
    chatBox.classList.add('active');
  }
});

// 닫기 버튼 클릭 시
document.querySelector('.function_01_click_close_chat').addEventListener('click', function () {
  const chatBox = document.querySelector('.function_01_action_chat');
  if (chatBox.classList.contains('active')) {
    chatBox.classList.remove('active');
  }
});s
// 채팅창 자동 스크롤 기능!!! END


























(function($) {
  "use strict";






  $(document).ready(function () {



    // 표 내용 수정!!!!!!! editable_tb 클래스를 가진 td에 적용
    $('table').each(function() { // 모든 테이블에 대해 각각 처리
      var $table = $(this); // 현재 테이블 jQuery 객체

      $table.find('td.editable_tb').each(function() {
        var $cell = $(this);
        var originalValue = $cell.text();

        $cell.off('click').on('click', function() {
          var $input = $('<input type="text" value="' + originalValue + '">');
          $cell.html($input);
          $input.focus();

          $input.blur(function() {
            var newValue = $input.val();
            if (newValue !== originalValue) {
              $cell.text(newValue);
              // AJAX 등을 사용하여 서버에 변경된 값 전송 가능
            } else {
              $cell.text(originalValue);
            }
          });
        });
      });
    });

    // Table focus functionality
    const $tables = $('table');
    let $focusedTd = null;
    let $focusedTr = null;

    $tables.on('click', function (event) {
        const $target = $(event.target);

        if ($target.is('td, th, input')) {
            if ($focusedTd) {
                $focusedTd.removeClass('focused');
            }
            if ($focusedTr) {
                $focusedTr.removeClass('focused');
            }

            if ($target.is('input')) {
                $focusedTd = $target.closest('td');
            } else {
                $focusedTd = $target;
            }
            $focusedTr = $focusedTd.closest('tr');

            // "row_checkbox" 클래스가 있는 input 요소가 없을 경우에만 "focused" 클래스 추가
            if (!$tables.find('.row_checkbox').length) {
                $focusedTr.addClass('focused');
            }

            // td는 항상 "focused" 클래스 추가
            $focusedTd.addClass('focused');
        }
    });



    $(document).on('click', function (event) {
        let isClickInsideTable = false;

        $tables.each(function () {
            if ($(this).has(event.target).length) {
                isClickInsideTable = true;
            }
        });

        if (!isClickInsideTable) {
            if ($focusedTd) {
                $focusedTd.removeClass('focused');
                $focusedTd = null;
            }
            if ($focusedTr) {
                $focusedTr.removeClass('focused');
                $focusedTr = null;
            }
        }
    });


  });





  // Select2
  $(document).ready(function() {

    // 검색창 없는 일반
    $('.js_select2_ver01').select2({
      minimumResultsForSearch: Infinity, // 검색 창 제거
      placeholder: "선택해 주세요.",
      // allowClear: true // X 버튼을 추가하여 선택 해제 가능
    });

    // 검색창 있는 일반
    // $('.js_select2_ver02').select2();
    $('.js_select2_ver02').select2({
      placeholder: "선택해 주세요.",
      // allowClear: true // X 버튼을 추가하여 선택 해제 가능
    });

    // Chip tag
    $('.js_select2_ver03').select2({
      tags: true, 
      tokenSeparators: [',', ' '], // 콤마(,)나 스페이스로 구분 가능
      placeholder: "선택해 주세요.", 
      // allowClear: true, // X 버튼을 추가하여 선택 해제 가능
    });

  });






})(jQuery);