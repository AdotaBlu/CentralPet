<header>
	<a href="<%=request.getContextPath()%>/home">
		<div class="ini">
			<img  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAH4AAAB+CAYAAADiI6WIAAAACXBIWXMAACxLAAAsSwGlPZapAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAABGTSURBVHgB7Z17cFTVHcd/9wJloyCLWiQ61aWTUFEhCQzyUMii7SgviaOFaQtDEMdOC0j4Q0c0HZIR6oM/SEad6WCBMDhTQR2gCI5TkQV8oKMQ1CoVRjZWJNgpBAgSKu7p+d7dG282e3fv49yn+cxcdjd7NyT5nt/v/M7v/M45EoWAeLQm2tERKedPY5LEyhmTBijP+aXcwOQoSSza/ZMsSZLUxhhTLkmSDvLP8kfWHIl0NCfaGtoopEgUQMZGHolzgbjQqUpZwqMUI2dIpliqmUjejcawr+PJBIWEQAgPiz5/vqia//FnSEwuz229LsC9QYq+T3DPsJW/SvCGkKSA4lvhu4hNUpx8CCOW4A/rKYCNwHfCw43zH6qa98szPLNsC/BG0MQf1gelO/CN8BCcPyxz2rr7RSPUf0CE+g0o4lck5z3tpzv4dZ6Ot1iI7SRq5oFiI28ATeRjPBc+beHSOlIjcAFA3NLhxVQ64moqjkWp+NqBVFpWrIjdPxox9b3OtnXQ4Y++pnbl8bjyHA0CzwuQ5F6g3q8NwDPhRVo4hJ447QZF3JEThyiCOw0axIE9X9D+PUfpwN4v8jUENIB5fusCXBeeCx7jD+vsCl58XZQmzx7Jhf65cnnN8ZZTvBF8QTs27OcN4Wi39zMxQL1fgkBXhR/Td2mNTNIyq0EbLHvK70bRxLuG+UJsPdRGsOnZd7p6AkZtTGINXPx68hhXhLdr5RUThnCxb6Aps0eZ7qO9BjHBxmfeoR0v7Nd+Ge5/kpfW77jwdqwcgs+vvV24dbNkI9EVlST1Lye3gBfY+OzbtGfbp9SK0QK3fp4Mqn/vwtMN5AGOCY8EzIULRcv4L1hDJnFKcMA+W0KplgaShzeRdM1cchs0gO0bPqS1K97M/ECphncvPLWEXMYR4eHaeQ59M2NkyqQGXzeQalff44zgJ3cTO1RD7Eyz8tor4VXQANYs36l2Aa67fuHCj+7zaHnvXmwzmRiXI2ibuWA83V/7S3ICdqSeUkfqunzNa+FV0AAW3PE83L+r4vcigYy75OEqmeTNvDkNNvoZuPVVf59HlXfdSKJRrJy7dvbvv3R7T7qqiqTL3Ovj9egfLaJZC2/BcC/avCdZ/bO+4//11XdvHyKHEWbxYyNL5/Jv1mT0flj5/MduV35pIVxsI/bVemJn066cTiaInU/q3i7fvIuky+PkJ1Tr55nB6n0dT6wnBxEivFnR0Zc/9/r9PAkzkESAKJ1xV84uGsytF8WoV+VR8it/Xf4GrVnxpqPi23b1ZkWfMqeCntw4h64Y3J9swy06deDutCtPdRj+mBSr8Z21a0FwyzOTVezo9clPWl8/SA5gS3j06RKTXzR6//za26hm5XTqG+lNdmHHuFvfz0U/Z6E7RHfwvxMkXXkn+ZWhZVfT+MnXV11xYezBnR9sFN7nW3b1GLJx0Q8YScygP1/89FSaOmcUiSBXlG4aHtj1Gn+A/M6ZU+fbLhtYNEmSpGYSiCXhFdFJ2kUGhmwQHf25kBkz3oenYOU8cLNF72g6uPNBVG8QBC81XHxhfb4ln2tUdKFBHPrz9yfljdSNEjDRAbxqE+MZMVHiy2SScUVLV5HbonNS3L2LEF0atipoomuB+EKyTqZcvTLhItGqQvfBva/ft0iY6LD273cPIbtIJctILqmjEFBt1/INW7ySf8csWwHUPl2Y6Bx2RsCIhlt5SEQHsPw42cCw8Eq/biCCR/QuvPSpzwCyi3x9QUcVNPgkGIuRRQwJz60dlh4rdB/G6aKGbFqQbLGbcPFzwsYiMMJdVsUv2McbHa/PXDieJ2emkZOwTP4dEy9kND0LfJ6itQlW9kwikxS0eN4y6gqJjgh+/mPOTKl2+Vm41crXVPPp1GoyBUYDZhpKsIhzqzfdj+UVPl0CLRUcPiCYc7MWTrqsjMwiYijoY2q4+FVmPpBX+MxCh7wsXjlVaARviN4W/r/vQmvxKuvM9Pe6wnNrr6YCAR2KKITNp5uhj8m6Td7HhzC4ywZ/lIKGqqIrvGRgzF77/L3kBWrdnCG46HLFZvqREDfq8nMKb8TaMXRz3cWrnDUgPATnkTyi+UIpWpQ9r1mxk0ICXH5Bl5hzkkaW5MWYENDDrSheF53ZuZe2jabj/7mMHrxvZ7qmjosPsM6t9ctTdPjgcWXhJBZS4rEVla5ccKx6ATMX3BK4BRs5gOjw1nlLtrsJn95mhOU1EdTKeQU71qQboR8+Oohe2zWC2s8VUc2qMYQaH1jzWi4uxC8EGkf/aDGFAET5jXx8n9S7oZvwyqYEecBq1KlzRpInIHlzpPCys9feHE5vVX7OrXqlUsBoFHiE0hGhEB4g0NNN7HTp49Nr3PKP27209kJTsyVDvul8Dgs3IzrACtwQEc83kZMd3OneCGDtFV6tUoW1H2vKe8uEMZ+THfpFiyhk6I7MsoX3tbUXonjQaRrMLysgYA2Rm1fRtfpO4TN1dHG974A/jJ+tXWXypI/ICkPDJ7pKTmPWWnyc8uCptR8zXmwyYcxhskIIrV2lKte4vlN4SSLdjA+s3bNIHhxrMnxr6ZATVHHjl9RDJxC921L1Hyw+JVfqfXLkBPv1blZRFj6anFkrv6mFzGJpa7Pg0M3dK8Ir06955txnLfJgIiaD0b5dy8zpH1C/Sy+Y+gx2rgoxsewgTxE+vSFwbjyNdvlUKjuxhczS79IOWnTfP0x9BmP+A3tCLX6XrlwRXpb1B/oTp99AXsG+2WK5cmbKbR+b7uuXP/CKodRuQOni7tN9PJN0S1oqpw8jr1A2KbLBrSYTOrD6tX9+g0JKVOvu5Xi0Dn17LNedqJH3auyOOXdmZPo1D8UWkjnYmmz7hv0UUuLqE7mjo0O3fx85wbtNBFmLPWu3Q+PDrxrZqzaIdI7c5HyB3QQP+3eyuyKWs/f9UrICNixufOhVCiFxNZkjS3mGcUPLvInm2Ymttqti289F+PTsCLIKNifeu+1TCiGKoXPhc+9Fp2z97dEwTonmbYKiDLugiCOEpIVnjHIuTPN00kKAmz/wybVkF1h9CDN6yghOliU5p6svcWHP91xYSdHmAq5eBCFM6sTxD7d4lrNU1qtqFFOl03loP9eXRLDGYL1egED6NooEznW53vXM1Qtw88Bsrl4PJHWqxz5juozL50R1F1R4VoYkaI0b8vWigOhzwyV+ua7wnkX0Z8W4elEWr4Kx/SMzXwiL289t8f2Cv6hAKcgQDbJ5Icnlx3IK33+Ah9WmvcUElaWaUmuRIJcfgkifWzyTug1UvawvV5c92QV9vNWK20KEYJ3dAJkk5sxfxyoC96CbcLO9Ons9wpDYMb3BodNIg2aQKOwusMjHnm3/pAAzRGbEfLUrkLKBgcB+XnR0rxL0CRxYvPmSVCfpE1WWOIsA/XxpTHx0Dz4P+Hw9Zuf811kJPA/OSqm1ETCuD/KYHrNzYjImApEE7GSp4tSwDmA9fUA5ClefzP6q5xFrkbgFHCVDnHH1AOvpg4ociUR8Z/EiKR7kr9GqT2iRE211MO8uHWGYZqJEzcuHjLb0OF5i3azeS3cvak4eiCjB0uPs6fMUUJKK8KmUlMh+p92rXwrTsi0NJIrXdg0npwjwWD5t8VIOi/cqcFHOkRM0J7/uxVttVdoWAqnbgE7YNCvC7+t4MpE9WeNFggI7Woly8yi2XLtxAjlNANfbtUmS1PZDrj7L6lvdDvBwypTds+Q0OOnitSAQXjprAwUI5ZyXTuFTjLZq33V7CRETVGunsve9X5BbwOVj2VVAUAy8U/iior5N2nfRkt10YSirFgXcvKgqW6OgQCMg6+0S+KdT+Mx4PqG9w9VdIgQFdEDEYgorBGSVbVeLB9nuHi7MNQRV3oAjyavIC9r9H+Ql1f1tuwivuHtNdO+mxYsswGhvd9fNB4iE+qSL8Iq7l1in1WMs71Y/rxRgCLL69m9DtzWpKDq17VZ6xYg1aV/veOFDcoU+UZKHGz5ZIy9nz3lj8QEoS0+oT7oJryRzNDe4mZYUWXblBT7f/Xo3Ejfqi5zFltzqO3cMRoDn5rBOVNmVF4z0aq9fYzRpX+QUPmP1SfW1a+4eCEjZljpYfKFHAHa/7rLbhG55Nbf6eepzt9x96uN5QtbOlXuwl63eJs/wlgeUOnxPaxyatG4e6Aqv7etdmYXCLpaC0rbY3NCpsupc5NvkecUDL9OCO55XVtt6mNnrtv133gUV2r5+97bPyFEQ1Qs6Hw5l1Q+a3NLUKhAdR6zqsSfjLZHc8WiqG0mbRPYX8wqvtXr0804HeTgfzvSBwTpM5lY/b9Zb5CSq6J6dv2eMnEd7FFxCpfT1PJuHFrvpOed3gZJKlnUZ0kmDqpTxvVRSR2RmuMeTQfNrb6eXXv2WKsaJFwbHpq/ft8jvosPam3K9UfD8eDCuaGkNbwGrkKB45bOHHT+UTzltCnPzXOheN+/q9r5SrIHjSr7ZqrutuTSsgeTrFne+RnC1g0+iwPVa6WsRsStXWTFNmT3K0N8A/+c916/sfF27+l6a4u6BD/NsCQ/GRZZCgTisyPFjShDoYa87nBZZwMJZ5rya7PPopJI6kktyH8KELuvwR18r/e7y37+sO7kCV167+h7L43MExQt5YKfisvCwdt0FCoZXy6ouH5v+OZ7Qwfo53tdLBtw61tPLJXXKObLaXD88ht4oAdYKMSfedQNNnKa/beufbIgO0Li0uJzSzXtsl2HheaCXJJnVK/u8+rDaRGkAWd2CkY2QB+fpo8+ettfAs6e1XUzw6PbtKqbWx797/okG/g0b0Vf6sboU4kuaBZdGCjfv513XYJ0ce+ND2y0nXvA5beILsYGLgeDdhW4wvTHCT/r+pI6L39zA/yh+pEtpdh9jI4CnNs3OKb4anC3nSRgzDQD3avt2UOHeFvDI0hVs8YaDOy2Zwwl3LV45NTZrocMHFSF4O7mbz9xVFpyvR4CnrdRFnGB0qhdiIcPWmmcFUemIq3mGrkI5vCGX28bqI+Q7NuWIg1459JAbFp/k16R8p0irWBIejO7zaPnAKyO7mt5dGHXyF0olG4kdqklvisSHd0rQd/kPJ6Wx8y1EJ7Yoo4DsYA4Bn9nNlF585m0lX9FqYAlZ9u+t5xUw5q9ZOY1cYF6hvl3FsvBg3CVLq0pvKt68/r1F5Bh8aPf9OxXmijH5aEAatopkG1nA7Rs+VHa3arW5hnAK9xC1q39NLoDz4muM3tyLbPDVd28dKvpvWcu5Mx1VY381lByhVyQ9R3/xNA+zDczcca8gl/2N5J/eSXYYWnY1oRtD34+RTOuX5hoAhm5/ePwO+uPj9n4OgyT59Zv6+nrDwxBbFq/C+/zqpzbOWYdxsZPAlSvZOkTr3BN0Hk2GaB55/kEz0lU8DqAmfTDFisezSmPo6trR75fwC2N/F4sy8EeoMNKvO8JvR66q/jp5kvXgOtVkAVuuXsvHx19vHnRx9MER42N39o306dmNwB3quaVbWlMuxNVr4S0QGRSk0IJbNRkMTAVz2Qjf2TKTPFhCPTjJFjuiA+EWr5Lpe8QUyvegBYY1KbuGziyOCQ96xBeOENGBo5sYZ7JI86gHEaBgUojowFGLV+kJ+GzTaLdPz8aVbcszAR/Pu3bfRbOHgtSLFh24YvEq3PJj/AE11OXUQyHg0pcYnXQxi6vCq/AGUMcfllEPeiTJ4PSqVTw5oYL/QnWUDvqS1EM2qBdzPPfuicWrZFx/Hb/mUg9w7XfnWvXiBJ6eSYNWza9q6rF+WPkQt0QHnlq8loz1I3pdTD8esMdbnZuC+xY0AH41sXBzlFmcTg09LJwN4BS/6vjVk8gqBAtHA0gwn1m4b/r4QrB0DBCn9Pg/Rv4HUTq2F2vyYx8eGOG18EYQ5w/V/EKddYz8BQK2LZRj+xE/EUjhtWQagXpVkvvgPJ9E5triZ7G1BF54LSwdNJVnrjilvUEZiQOiYr/35syV8Ky61SahEl4Plp4WRqOIZa5o1qXSlrlAUvMaIieDYs1G+D9TX+SykO269AAAAABJRU5ErkJggg=="
				alt="logo">
			<h1>Central Pet</h1>
		</div>
	</a>
	<ul class="mid">
	<a href="<%=request.getContextPath()%>/mostrar-cards-ongs"><li>Ongs</li></a>
		<a href=""><li>Acompanhamento</li></a>
	</ul>
	<ul class="end">
		<a id="botao-adotar" href="<%=request.getContextPath()%>/mostrar-cards-pets"><button = class ="botao-adotar-miniatura">Adotar</button></a>
		<div class="li">
			<img class ="foto-miniatura"src='<c:out value="${tutor.urlImagem}"></c:out>' alt="miniatura-tutor"  width="30px" height="30px"> 
			<a href=""><li>Minha Conta</li></a>
		</div>
		<a href="<%=request.getContextPath()%>/sair"><button>Sair</button></a>
	</ul>
</header>