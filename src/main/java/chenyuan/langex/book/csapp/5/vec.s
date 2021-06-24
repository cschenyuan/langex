	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 10
	.globl	_new_rec
	.align	4, 0x90
_new_rec:                               ## @new_rec
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp0:
	.cfi_def_cfa_offset 16
Ltmp1:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp2:
	.cfi_def_cfa_register %rbp
	pushq	%r14
	pushq	%rbx
Ltmp3:
	.cfi_offset %rbx, -32
Ltmp4:
	.cfi_offset %r14, -24
	movq	%rdi, %r14
	movl	$16, %edi
	callq	_malloc
	movq	%rax, %rbx
	xorl	%eax, %eax
	testq	%rbx, %rbx
	je	LBB0_7
## BB#1:
	movq	%r14, (%rbx)
	testq	%r14, %r14
	jle	LBB0_5
## BB#2:
	movl	$4, %esi
	movq	%r14, %rdi
	callq	_calloc
	testq	%rax, %rax
	je	LBB0_3
## BB#4:
	movq	%rax, 8(%rbx)
	jmp	LBB0_6
LBB0_5:
	movq	$0, 8(%rbx)
LBB0_6:
	movq	%rbx, %rax
	jmp	LBB0_7
LBB0_3:
	movq	%rbx, %rdi
	callq	_free
	xorl	%eax, %eax
LBB0_7:
	popq	%rbx
	popq	%r14
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_get_vec_element
	.align	4, 0x90
_get_vec_element:                       ## @get_vec_element
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp5:
	.cfi_def_cfa_offset 16
Ltmp6:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp7:
	.cfi_def_cfa_register %rbp
	xorl	%eax, %eax
	testq	%rsi, %rsi
	js	LBB1_3
## BB#1:
	cmpq	%rsi, (%rdi)
	jle	LBB1_3
## BB#2:
	movq	8(%rdi), %rax
	movl	(%rax,%rsi,4), %eax
	movl	%eax, (%rdx)
	movl	$1, %eax
LBB1_3:
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_get_vec_start
	.align	4, 0x90
_get_vec_start:                         ## @get_vec_start
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp8:
	.cfi_def_cfa_offset 16
Ltmp9:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp10:
	.cfi_def_cfa_register %rbp
	movq	8(%rdi), %rax
	popq	%rbp
	retq
	.cfi_endproc

	.globl	_vec_length
	.align	4, 0x90
_vec_length:                            ## @vec_length
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp11:
	.cfi_def_cfa_offset 16
Ltmp12:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp13:
	.cfi_def_cfa_register %rbp
	movq	(%rdi), %rax
	popq	%rbp
	retq
	.cfi_endproc


.subsections_via_symbols
