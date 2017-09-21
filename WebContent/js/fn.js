(function($) {
	$(function() {

		$('.nav li ul').hide();
		$('.nav li a.current').parent().find('ul').slideToggle('slow');
		
		$('.nav li a').click(
			function() {
				$(this).parent().siblings().find('ul').slideUp('normal');
				$(this).parent().siblings().find('a').removeClass('current');
				$(this).next().slideToggle('normal');
				$(this).addClass('current').fadeIn();

				return false;
			}
		);
		$('.nav ul li a').click(
			function() {
				$('.nav ul li a.current').removeClass('current');
				$(this).addClass('current');
				return false;
			}
		);
		$('.nav li a').hover(
			function() {
				$(this).stop().animate({ paddingRight: "45px"}, 200);
			},
			function() {
				$(this).stop().animate({ paddingRight: "30px"});
			}
		);

		//Minimize Content Box
		$('.content-box-header h3').click(
			function() {
				$(this).parent().next().toggle();
				$(this).parent().toggleClass('closed-box');
			}
		);
	});
})(jQuery);