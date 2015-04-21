$(function() {
				var $l = $('#carousel-left'),
					$c = $('#carousel-center'),
					$r = $('#carousel-right');
					
				$l.carouFredSel({
					auto: false,
					items: 1,
					direction: 'right',
					prev: {
						button: '#prev',
						fx: 'uncover',
						onBefore: function() {
							setTimeout(function() {
								$c.trigger( 'prev' );
							}, 100);
						}
					},
					next: {
						fx: 'cover'
					}
				});
				$c.carouFredSel({
					auto: false,
					items: 1,
					prev: {
						onBefore: function() {
							setTimeout(function() {
								$r.trigger( 'prev' );
							}, 100);
						}
					},
					next: {
						onBefore: function() {
							setTimeout(function() {
								$l.trigger( 'next' );
							}, 100);
						}
					}
				});
				$r.carouFredSel({
					auto: false,
					items: 1,
					prev: {
						fx: 'cover'
					},
					next: {
						button: '#next',
						fx: 'uncover',
						onBefore: function() {
							setTimeout(function() {
								$c.trigger( 'next' );
							}, 100);
						}
					}
				});
			});